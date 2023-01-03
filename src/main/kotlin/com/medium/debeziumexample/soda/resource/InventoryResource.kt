package com.medium.debeziumexample.soda.resource

import com.medium.debeziumexample.soda.domain.Soda
import com.medium.debeziumexample.soda.entity.SodaOperationEntity
import com.medium.debeziumexample.soda.enum.OperationEnum
import com.medium.debeziumexample.soda.repository.InventoryEntityRepository
import com.medium.debeziumexample.soda.repository.SodaOperationEntityRepository
import com.medium.debeziumexample.soda.use_case.ChangePriceOfSodaUseCase
import com.medium.debeziumexample.soda.use_case.GetRegisteredSodasUseCase
import com.medium.debeziumexample.soda.use_case.RegisterNewSodaOnInventoryUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal
import java.util.*

@RestController
@RequestMapping("/soda")
class InventoryResource(
    private val getRegisteredSodasUseCase: GetRegisteredSodasUseCase,
    private val registerNewSodaOnInventoryUseCase: RegisterNewSodaOnInventoryUseCase,
    private val changePriceOfSodaUseCase: ChangePriceOfSodaUseCase,
    private val inventoryEntityRepository: InventoryEntityRepository,
    private val sodaOperationEntityRepository: SodaOperationEntityRepository,
) {

    @PostMapping("/teste")
    fun teste() = sodaOperationEntityRepository.save(
        SodaOperationEntity(
            id = UUID.randomUUID(),
            quantity = 3,
            BigDecimal.TEN,
            OperationEnum.INPUT,
            sodaId = UUID.randomUUID(),
            payload = "{\"id\":38}"
        )
    )

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
