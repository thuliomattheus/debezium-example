package com.medium.debeziumexample.soda.broker

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.stereotype.Service

@Service
class SimpleConsumer {

    @KafkaListener(
        id = "simple-id",
        clientIdPrefix = "simple-client-id-prefix",
        topics=["topic.dbserver1.inventory.customers"],
    )
    fun consume(message: Any, ack: Acknowledgment) {
        message.toString()
        ack.acknowledge()
    }
}
