package com.quid.kafka.throughput

import com.quid.java.thread.Sleep.sleep
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.Acknowledgment
import org.springframework.stereotype.Component

@Component
class Producer(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {
    val log = LoggerFactory.getLogger(this::class.java)!!

    fun throughputConsumer() {
        log.info("Sending messages")
        IntRange(0, 10000)
            .forEach { kafkaTemplate.send("throughput", "Message $it") }
        log.info("Messages sent")
    }
}

@Component
class Consumer {
    val log = LoggerFactory.getLogger(this::class.java)!!

    @KafkaListener(topics = ["throughput"], groupId = "playground")
    fun throughputConsumer(message: String, ack: Acknowledgment) {
        log.info("Received message: $message")
        sleep(1000)
        log.info("Message processed")
        ack.acknowledge()
    }
}