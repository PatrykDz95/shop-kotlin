package com.example.kotlin.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = -1,
    val firstName: String,
    val lastName: String,
    @OneToMany
    val user: List<Item>
)