package com.medium.debeziumexample.soda.repository

import com.medium.debeziumexample.soda.entity.InventoryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InventoryEntityRepository: JpaRepository<InventoryEntity, Long>
