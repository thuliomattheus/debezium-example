package com.medium.debeziumexample.soda.domain

import com.medium.debeziumexample.soda.entity.SodaEntity
import java.math.BigDecimal

data class SodaWithPriceUpdated (
    val name: String,
    val oldPrice: BigDecimal,
    val updatedPrice: BigDecimal,
) {
    companion object {
        fun fromEntity(sodaEntity: SodaEntity) = SodaWithPriceUpdated(
            name = sodaEntity.name,
            updatedPrice = sodaEntity.price,
            oldPrice = sodaEntity.oldPrice,
        )
    }
}
