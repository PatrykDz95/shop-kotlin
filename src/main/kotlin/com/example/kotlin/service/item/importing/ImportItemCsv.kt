package com.example.kotlin.service.item.importing

import com.example.kotlin.model.Item
import org.apache.commons.csv.CSVFormat
import org.springframework.stereotype.Component
import java.io.InputStream
import java.time.LocalDate

@Component
class ImportItemCsv {

    fun readCsv(inputStream: InputStream): List<Item> =
        CSVFormat.Builder.create(CSVFormat.DEFAULT).apply {
            setIgnoreSurroundingSpaces(true)
        }.build().parse(inputStream.reader())
            .drop(1) // Dropping the header
            .map {
                Item(
                    cost = it[0].toDouble(),
                    name = it[1],
                    boughtDate = LocalDate.parse(it[2]),
                    returnDate = it[3]
                )
            }
}