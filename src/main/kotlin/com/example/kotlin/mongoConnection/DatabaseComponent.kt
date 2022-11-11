package com.example.kotlin.mongoConnection

import com.example.kotlin.model.Item
import com.example.kotlin.model.Job
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection
import org.springframework.stereotype.Component

@Component
class DatabaseComponent {
    val client = KMongo.createClient()
    val database = client.getDatabase("Items")
    val col = database.getCollection<Item>()
}