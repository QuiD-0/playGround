package com.quid.kafka.throughput

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL

@SpringBootTest
@ActiveProfiles("dev")
@TestConstructor(autowireMode = ALL)
class ProducerTest(
    private val producer: Producer
) {
    @Test
    fun produce() {
        producer.throughputConsumer()
    }
}