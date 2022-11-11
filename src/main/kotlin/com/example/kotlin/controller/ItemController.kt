package com.example.kotlin.controller

import com.example.kotlin.model.Item
import com.example.kotlin.service.ItemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class ItemController {

    @Autowired
    lateinit var itemService: ItemService

    @RequestMapping("/find/{item}")
    fun find(@PathVariable item: String) = itemService.findItem(item)

    @RequestMapping("/findItems")
    fun findAll(): List<Item> {
        val items = itemService.findItems().toList()
        return items
    }

    @PostMapping("/saveItem")
    fun save(@RequestBody item: Item): Item {
        return itemService.addItem(item)
    }

}