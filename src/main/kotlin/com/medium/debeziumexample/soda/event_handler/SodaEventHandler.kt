package com.medium.debeziumexample.soda.event_handler

import com.medium.debeziumexample.soda.domain.SodaWithPriceUpdated
import com.medium.debeziumexample.soda.entity.SodaEntity
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class SodaEventHandler {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(SodaEventHandler::class.java)
    }

    @EventListener
    fun handleNewSodaRegistered(registeredSoda: SodaEntity) {
        logger.info("Novo refrigerante cadastrado: ${registeredSoda.name}")
    }

    @EventListener
    fun handleSodaPriceUpdated(updatedSoda: SodaWithPriceUpdated) {
        logger.info("O preço do refrigerante ${updatedSoda.name} foi alterado no estoque.\n" +
            "Preço antigo: R$ ${updatedSoda.oldPrice.setScale(2)}\n" +
            "Preço atual:  R$ ${updatedSoda.updatedPrice.setScale(2)}")
    }
}
