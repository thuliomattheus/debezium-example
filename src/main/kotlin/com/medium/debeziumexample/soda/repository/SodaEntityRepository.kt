package com.medium.debeziumexample.soda.repository;

import com.medium.debeziumexample.soda.entity.SodaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository;
import java.util.*

@Repository
interface SodaEntityRepository : JpaRepository<SodaEntity, UUID> {

    fun existsByNameAndCompany(name: String, company: String): Boolean
    fun findByBarCode(barCode: String): Optional<SodaEntity>
}
