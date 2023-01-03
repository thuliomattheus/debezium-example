package com.medium.debeziumexample.soda.entity

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class InventoryEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long,
    val teste: String = "teste"
)