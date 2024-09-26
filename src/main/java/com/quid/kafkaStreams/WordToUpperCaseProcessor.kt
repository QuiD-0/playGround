package com.quid.kafkaStreams

import org.apache.kafka.common.serialization.Serde
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.kstream.Consumed
import org.apache.kafka.streams.kstream.ValueMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*


@Component
class WordToUpperCaseProcessor {

    @Autowired
    fun buildPipeline(streamsBuilder: StreamsBuilder) {
        streamsBuilder
            .stream("input-topic", Consumed.with(STRING_SERDE, STRING_SERDE))
            .peek() { key, value -> println("INPUT :: key: $key, value: $value") }
            .mapValues(ValueMapper { obj: String -> obj.uppercase(Locale.getDefault()) } as ValueMapper<String, String>)
            .peek { key, value -> println("OUTPUT :: key: $key, value: $value") }
            .to("output-topic")
    }

    companion object {
        private val STRING_SERDE: Serde<String> = Serdes.String()
    }
}