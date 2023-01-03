package com.medium.debeziumexample.soda.entity

import com.medium.debeziumexample.soda.domain.SodaOperation
import com.medium.debeziumexample.soda.enum.OperationEnum
import org.springframework.data.annotation.CreatedDate
import java.math.BigDecimal
import java.time.Instant
import java.util.*
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Id

@Entity
data class SodaOperationEntity(
    @Id val id: UUID,
    val quantity: Long,
    val price: BigDecimal,
    @Enumerated(value=EnumType.STRING) val operation: OperationEnum,
    val sodaId: UUID,
    @CreatedDate val createdAt: Instant = Instant.now(),
    val payload: String,
    ) {
    companion object {
        fun fromDomain(sodaOperation: SodaOperation): SodaOperationEntity = sodaOperation.run{
            SodaOperationEntity(
                id = id,
                sodaId = sodaId,
                quantity = quantity,
                price = price,
                operation = operation,
                payload = "{\"id\":38}",
            )
        }
    }
}
