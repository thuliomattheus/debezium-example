package com.medium.debeziumexample.soda.resource

import com.medium.debeziumexample.soda.domain.Soda
import com.medium.debeziumexample.soda.use_case.ChangePriceOfSodaUseCase
import com.medium.debeziumexample.soda.use_case.GetRegisteredSodasUseCase
import com.medium.debeziumexample.soda.use_case.RegisterNewSodaOnInventoryUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/soda")
class InventoryResource(
    private val getRegisteredSodasUseCase: GetRegisteredSodasUseCase,
    private val registerNewSodaOnInventoryUseCase: RegisterNewSodaOnInventoryUseCase,
    private val changePriceOfSodaUseCase: ChangePriceOfSodaUseCase,
) {

    @GetMapping
    fun getRegisteredSodas() = getRegisteredSodasUseCase.getRegisteredSodas()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun registerNewSoda(@RequestBody soda: Soda) = registerNewSodaOnInventoryUseCase.registerNewSoda(soda)

    @PutMapping("/{barCode}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun changePriceFromBarCode(
        @PathVariable barCode: String,
        @RequestParam newPrice: BigDecimal
    ) = changePriceOfSodaUseCase.changePriceOfSoda(barCode, newPrice)
}
