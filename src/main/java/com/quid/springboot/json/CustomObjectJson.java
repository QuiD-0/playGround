package com.quid.springboot.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class CustomObjectJson {

    public static class Serializer extends JsonSerializer<JsonObject> {
        @Override
        public void serialize(JsonObject o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField(o.name(), o.value());
            jsonGenerator.writeEndObject();
        }
    }

    public static class Deserializer extends JsonDeserializer<JsonObject> {
        @Override
        public JsonObject deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            jsonParser.nextToken();
            String name = jsonParser.getValueAsString();
            jsonParser.nextToken();
            String value = jsonParser.getValueAsString();
            return new JsonObject(name, value);
        }
    }

    public record JsonObject(String name, String value) {
    }
}
