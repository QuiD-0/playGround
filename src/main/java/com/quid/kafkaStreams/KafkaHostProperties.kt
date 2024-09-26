package com.quid.kafkaStreams

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "spring.kafka")
data class KafkaHostProperties(
    val bootstrapServers: String
)