package com.example.kotlin.configuration

import com.example.kotlin.service.file.FilenameProvider
import com.example.kotlin.service.item.export.ExportItemCsv
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ExportItemCsvConfiguration() {

    @Bean
    fun exportItemCsv(filenameProvider: FilenameProvider) : ExportItemCsv {
        return ExportItemCsv(filenameProvider);
    }

    @Bean
    fun filenameProvider() : FilenameProvider {
        return FilenameProvider();
    }
}
