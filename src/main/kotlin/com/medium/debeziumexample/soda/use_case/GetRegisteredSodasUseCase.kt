package com.medium.debeziumexample.soda.use_case

import com.medium.debeziumexample.soda.repository.SodaEntityRepository
import org.springframework.stereotype.Service

@Service
class GetRegisteredSodasUseCase(
    private val sodaRepository: SodaEntityRepository,
) {

    fun getRegisteredSodas() = sodaRepository.findAll()
}
