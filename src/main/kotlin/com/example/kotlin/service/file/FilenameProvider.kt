package com.example.kotlin.service.file

import java.util.*

class FilenameProvider {

    fun forCsvImport(): String
    {
        val newUUID = UUID.randomUUID().toString()
        return "import-$newUUID.csv"
    }
}