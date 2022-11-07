package com.example.kotlin.controller;

import com.example.kotlin.model.Customer
import com.example.kotlin.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class UserController {
    @Autowired
    lateinit var repository: CustomerRepository

    @PostMapping("/saveCustomer")
    fun save(@RequestBody customer: Customer): Customer {
        return repository.save(customer)
    }

    @RequestMapping("/findall")
    fun findAll() = repository.findAll()

    @RequestMapping("/findbyid/{id}")
    fun findById(@PathVariable id: Long) = repository.findById(id)

    @RequestMapping("findbylastname/{lastName}")
    fun findByLastName(@PathVariable lastName: String) = repository.findByLastName(lastName)
}
