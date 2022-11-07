package com.example.kotlin.service

import com.example.kotlin.model.Item
import com.example.kotlin.repository.ItemRepository

class ItemService(private val itemRepository: ItemRepository) {

    fun findItem(name: String): Iterable<Item> {
        return itemRepository.findByName(name)
    }

    fun findItems(): Iterable<Item> {
        return itemRepository.findAll()
    }

    fun addItem(item: Item): Item {
        itemRepository.save(item)
        return item
    }
}