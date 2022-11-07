package com.example.kotlin.configuration

import com.example.kotlin.repository.ItemRepository
import com.example.kotlin.service.ItemService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ItemServiceConfiguration() {

    @Bean
     fun itemService(itemRepository: ItemRepository) : ItemService {
         return ItemService(itemRepository);
    }
}