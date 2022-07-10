package com.medium.debeziumexample.soda.entity

import com.medium.debeziumexample.soda.domain.SodaOperation
import com.medium.debeziumexample.soda.enum.OperationEnum
import java.math.BigDecimal
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class SodaOperationEntity(
    @Id val id: UUID,
    @ManyToOne val soda: SodaEntity,
    val quantity: Long,
    val price: BigDecimal,
    val operation: OperationEnum,
) {
    companion object {
        fun fromDomain(sodaOperation: SodaOperation): SodaOperationEntity = sodaOperation.run{
            SodaOperationEntity(
                id = id,
                soda = SodaEntity.fromDomain(soda),
                quantity = quantity,
                price = price,
                operation = operation
            )
        }
    }
}
