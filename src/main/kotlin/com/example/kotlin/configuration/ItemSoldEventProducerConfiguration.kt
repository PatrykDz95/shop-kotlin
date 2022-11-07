package com.example.kotlin.configuration

import com.example.kotlin.kafka.ItemSoldEventProducer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.KafkaTemplate


@Configuration
class ItemSoldEventProducerConfiguration(
    @Value("\${kafka.topics.item}")
    val topic: String,
    @Autowired
    private val kafkaTemplate: KafkaTemplate<String, Any>
) {

    @Bean
    fun itemSoldEventProducer(): ItemSoldEventProducer {
        return ItemSoldEventProducer(topic, kafkaTemplate);
    }
}