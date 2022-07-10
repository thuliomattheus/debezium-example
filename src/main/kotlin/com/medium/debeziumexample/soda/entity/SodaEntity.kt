package com.medium.debeziumexample.soda.entity

import com.medium.debeziumexample.soda.domain.Soda
import com.medium.debeziumexample.soda.domain.SodaWithPriceUpdated
import org.springframework.data.domain.AbstractAggregateRoot
import java.math.BigDecimal
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.PrePersist
import javax.persistence.PreUpdate

@Entity
data class SodaEntity(
    @Id val id: UUID,
    val name: String,
    val company: String,
    var price: BigDecimal,
    val barCode: String,
): AbstractAggregateRoot<SodaEntity>() {

    @Transient
    var oldPrice: BigDecimal = BigDecimal.ZERO

    companion object {
        fun fromDomain(soda: Soda): SodaEntity = soda.run{
            SodaEntity(
                id = id,
                name = name,
                company = company,
                price = price,
                barCode = barCode,
            )
        }
    }

    // O valor pode ser alterado diretamente através da property, porém, o foco dessa POC é Debezium e Connector
    fun alterPrice(newPrice: BigDecimal) {
        this.oldPrice = price
        this.price = newPrice
    }

    fun registerCreatedEvent() = super.registerEvent(this)

    fun registerChangedPriceEvent() = SodaWithPriceUpdated.fromEntity(this).let {
        super.registerEvent(it)
    }
}
