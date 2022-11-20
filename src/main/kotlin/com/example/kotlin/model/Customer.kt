package com.example.kotlin.model

import javax.persistence.*

@Entity
@Table(name = "customer")
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 1,
    val firstName: String = "",
    val lastName: String = "",
    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.MERGE])
    val user: List<Item>? = null
){
}

// TODO: "message": "No default constructor for entity:  : com.example.kotlin.model.Customer; nested exception is org.hibernate.InstantiationException: No default constructor for entity:  : com.example.kotlin.model.Customer",
//"path": "/findall"