package com.example.kotlin.controller

import com.example.kotlin.service.ItemService
import com.example.kotlin.service.item.export.ExportItemCsv
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/csv")
class CsvController {

    @Autowired
    lateinit var itemService: ItemService
    @Autowired
    lateinit var exportItemCsv: ExportItemCsv

    @RequestMapping("/export")
    fun export(){
        val items = itemService.findItems()
        exportItemCsv.export(items)
    }
}