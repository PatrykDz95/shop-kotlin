package com.example.kotlin.service.item.export

import com.example.kotlin.model.Item
import com.example.kotlin.service.file.FilenameProvider
import kotlinx.coroutines.*
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVPrinter
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*


class ExportItemCsv(private var filenameProvider: FilenameProvider) {


    @Value("classpath:csv/")
    private val csvFolder: Resource? = null

    fun export(items: Iterable<Item>): String {
        val fileName = filenameProvider.forCsvImport()
        val writer = Files.newBufferedWriter(Paths.get(fileName));
        val csvPrinter = CSVPrinter(
            writer, CSVFormat.EXCEL
                .withHeader("id", "name", "boughtDate", "returnDate")
        )

        for (item in items) {
            val itemData = listOf(
                item.id,
                item.name,
                item.boughtDate,
                item.returnDate
            )
            csvPrinter.printRecord(itemData)
            csvPrinter.flush()
        }

        for (item in items) {
            val itemData = listOf(
                item.id,
                item.name,
                (0..9999).random().toString(),
                item.returnDate
            )
            csvPrinter.printRecord(itemData)
            csvPrinter.flush()
        }
        return fileName
    }
}