package com.quid.template;

import static java.nio.charset.StandardCharsets.UTF_8;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class RestTemplateLogging {

    public RestTemplate CustomRestTemplate() {
        return new RestTemplateBuilder()
            .requestFactory(() -> new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory(){{
                setConnectTimeout(10_000);
                setReadTimeout(10_000);
            }}))
            .interceptors((request, body, execution) -> {
                log.info("[Custom] REQUEST {} : {} ", request.getURI(), new String(body));
                ClientHttpResponse response = execution.execute(request, body);
                log.info("[Custom] RESPONSE : {}", StreamUtils.copyToString(response.getBody(), UTF_8));
                return response;
            })
            .messageConverters(
                new MappingJackson2HttpMessageConverter(new ObjectMapper()
                    .setSerializationInclusion(Include.NON_NULL)))
            .build();
    }

}
