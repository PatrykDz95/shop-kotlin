package com.example.kotlin.model

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "item")
data class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val cost: Double = 0.00,
    val name: String  = "",
    val boughtDate: LocalDate = LocalDate.now(),
    val returnDate: String = "",
)