package com.example.kotlin.repository

import com.example.kotlin.model.Item
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository : CrudRepository<Item, Long> {

    fun findByName(name: String): Iterable<Item>

}