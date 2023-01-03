package com.medium.debeziumexample.soda.domain

import com.medium.debeziumexample.soda.enum.OperationEnum
import java.math.BigDecimal
import java.util.UUID

data class SodaOperation(
    val id: UUID,
    val sodaId: UUID,
    val quantity: Long,
    val price: BigDecimal,
    val operation: OperationEnum,
)
