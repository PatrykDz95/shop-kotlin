package com.example.kotlin.service

import com.example.kotlin.kafka.ItemSoldEventProducer
import com.example.kotlin.model.Item
import com.example.kotlin.mongoConnection.DatabaseComponent
import com.example.kotlin.repository.ItemRepository
import org.springframework.beans.factory.annotation.Autowired

class ItemService(private val itemRepository: ItemRepository) {

    @Autowired
    lateinit var itemSoldEventProducer: ItemSoldEventProducer
    @Autowired
    lateinit var databaseComponent: DatabaseComponent

    fun findItem(name: String): Iterable<Item> {
        return itemRepository.findByName(name)
    }

    fun findItems(): Iterable<Item> {
        return itemRepository.findAll()
    }

    fun addItems(item: List<Item>) {
        itemRepository.saveAll(item)
    }

    fun addItem(item: Item): Item {
        itemRepository.save(item)
        databaseComponent.col.insertOne(item)
        itemSoldEventProducer.sendMessage(item)
        return item
    }
}