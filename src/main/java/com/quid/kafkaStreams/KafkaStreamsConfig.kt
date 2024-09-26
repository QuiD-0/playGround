package com.quid.kafkaStreams

import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.StreamsConfig.APPLICATION_ID_CONFIG
import org.apache.kafka.streams.StreamsConfig.BOOTSTRAP_SERVERS_CONFIG
import org.apache.kafka.streams.StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG
import org.apache.kafka.streams.StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.annotation.EnableKafkaStreams
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration
import org.springframework.kafka.config.KafkaStreamsConfiguration


@EnableKafka
@EnableKafkaStreams
@Configuration
class KafkaStreamsConfig(
    private val kafkaHostProperties: KafkaHostProperties
) {

    @Bean(name = [KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME])
    fun kStreamsConfig(): KafkaStreamsConfiguration {
        return KafkaStreamsConfiguration(
            mapOf(
                APPLICATION_ID_CONFIG to "streams-app",
                BOOTSTRAP_SERVERS_CONFIG to kafkaHostProperties.bootstrapServers,
                DEFAULT_KEY_SERDE_CLASS_CONFIG to Serdes.String().javaClass.name,
                DEFAULT_VALUE_SERDE_CLASS_CONFIG to Serdes.String().javaClass.name
            )
        )
    }

}

