package com.example.kotlin.model

import java.util.*

data class Job (
    var id: String = UUID.randomUUID().toString(),
    var user : String,
    var startTime: Date = Calendar.getInstance().time,
)