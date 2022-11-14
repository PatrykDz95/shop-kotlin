package com.example.kotlin.controller

import com.example.kotlin.service.ItemService
import com.example.kotlin.service.item.export.ExportItemCsv
import com.example.kotlin.service.item.importing.ImportItemCsv
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/csv")
class CsvController {

    @Autowired
    lateinit var itemService: ItemService
    @Autowired
    lateinit var exportItemCsv: ExportItemCsv
    @Autowired
    lateinit var importItemCsv: ImportItemCsv

    @RequestMapping("/export")
    fun export(){
        val items = itemService.findItems()
        exportItemCsv.export(items)
    }

    @PostMapping("/import")
    fun import(@RequestAttribute multipartFile: MultipartFile){
        val csvFile = importItemCsv.readCsv(multipartFile.inputStream)
        itemService.addItems(csvFile)
    }
}