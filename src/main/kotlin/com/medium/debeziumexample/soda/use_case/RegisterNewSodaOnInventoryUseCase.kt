package com.medium.debeziumexample.soda.use_case

import com.medium.debeziumexample.soda.domain.Soda
import com.medium.debeziumexample.soda.entity.SodaEntity
import com.medium.debeziumexample.soda.repository.SodaEntityRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RegisterNewSodaOnInventoryUseCase(
    private val sodaRepository: SodaEntityRepository,
) {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(RegisterNewSodaOnInventoryUseCase::class.java)
    }

    @Transactional
    fun registerNewSoda(soda: Soda) {
        with(soda) {
            if (!sodaRepository.existsByNameAndCompany(name, company)) {
                SodaEntity.fromDomain(this)
                    .run {
                        registerCreatedEvent()
                    }
                    .let {
                        sodaRepository.save(it)
                    }
            } else {
                logger.info("Esse item já foi adicionado ao inventário")
            }
        }
    }
}

