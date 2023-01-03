package com.medium.debeziumexample.soda.broker

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.stereotype.Service

@Service
class SimpleConsumer2 {

    @KafkaListener(
        id = "simple-id2",
        clientIdPrefix = "simple-client-id-prefix2",
        topics=["topico.INPUT"],
    )
    fun consume(message: Any, ack: Acknowledgment) {
        message.toString()
        ack.acknowledge()
    }
}
