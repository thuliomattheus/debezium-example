package com.medium.debeziumexample.soda.use_case

import com.medium.debeziumexample.soda.repository.SodaEntityRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class ChangePriceOfSodaUseCase(
    private val sodaRepository: SodaEntityRepository,
) {

    fun changePriceOfSoda(barCode: String, newPrice: BigDecimal) = sodaRepository.findByBarCode(barCode)
        .ifPresent {soda ->
            soda
                .apply {
                    alterPrice(newPrice)
                    registerChangedPriceEvent()
                }
                .let {
                    sodaRepository.save(it)
                }
        }
}
