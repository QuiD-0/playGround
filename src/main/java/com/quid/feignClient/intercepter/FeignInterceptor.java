package com.quid.feignClient.intercepter;

import static java.nio.charset.StandardCharsets.UTF_8;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

@Slf4j
@RequiredArgsConstructor(staticName = "of")
public class FeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        if (template.body() == null) {
            log.info("Request body is null");
            return;
        }

        String body = StringUtils.toEncodedString(template.body(), UTF_8);
        if (Objects.equals(template.method(), HttpMethod.GET.name())) {
            log.info("[GET] [FeignInterceptor] query params: {}", template.queries());
            log.info("[GET] [FeignInterceptor] body: {}", body);
            return;
        }
        if (Objects.equals(template.method(), HttpMethod.POST.name())) {
            log.info("[POST] [FeignInterceptor] body: {}", template.body());
            //필요한 로직 추가
        }
    }
}
