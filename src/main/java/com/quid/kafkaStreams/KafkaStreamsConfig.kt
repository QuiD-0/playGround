package com.quid.kafkaStreams

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.annotation.EnableKafkaStreams

@EnableKafka
@EnableKafkaStreams
@Configuration
class KafkaStreamsConfig(
    private val kafkaHostProperties: KafkaHostProperties
) {

    @Bean
    fun getBootstrapServers(): String {
        return kafkaHostProperties.bootstrapServers
    }
}

