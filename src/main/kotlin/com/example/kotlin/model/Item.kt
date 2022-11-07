package com.example.kotlin.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    val cost: Double = 0.00,
    val name: String  = "",
    val boughtDate: String = "",
    val returnDate: String = ""
)