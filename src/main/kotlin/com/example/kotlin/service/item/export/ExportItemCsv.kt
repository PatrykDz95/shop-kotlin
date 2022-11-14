package com.example.kotlin.service.item.export

import com.example.kotlin.model.Item
import com.example.kotlin.service.file.FilenameProvider
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVPrinter
import java.nio.file.Files
import java.nio.file.Paths


class ExportItemCsv(private var filenameProvider: FilenameProvider) {

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
        return fileName
    }
}