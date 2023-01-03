package com.medium.debeziumexample.soda.repository;

import com.medium.debeziumexample.soda.entity.SodaOperationEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface SodaOperationEntityRepository : JpaRepository<SodaOperationEntity, UUID>
