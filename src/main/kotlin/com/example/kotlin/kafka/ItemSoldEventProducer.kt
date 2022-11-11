package com.example.kotlin.kafka

import com.example.kotlin.model.Item
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder

class ItemSoldEventProducer(
    @Value("\${kafka.topics.item}")
    val topic: String,
    @Autowired
    private val kafkaTemplate: KafkaTemplate<String, Any>
) {
    private val log = LoggerFactory.getLogger(javaClass)

    fun sendMessage(items: Item) {
        try {
            log.info("Receiving product request")
            log.info("Sending message to Kafka {}", items)
            val message: Message<Item> = MessageBuilder
                .withPayload(items)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .setHeader("X-Custom-Header", "Custom header here")
                .build()
            kafkaTemplate.send(message)
        } catch (e: Exception) {
            log.error("Exception: {}", e)
        }
    }
}