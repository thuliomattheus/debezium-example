package com.medium.debeziumexample.soda.domain

import java.math.BigDecimal
import java.util.*

data class Soda(
    val id: UUID = UUID.randomUUID(),
    var name: String,
    var company: String,
    val price: BigDecimal,
    val barCode: String,
)
