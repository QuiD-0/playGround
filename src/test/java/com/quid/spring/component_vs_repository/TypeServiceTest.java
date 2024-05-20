package com.quid.spring.component_vs_repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TypeServiceTest {

    @Autowired
    private TypeService typeService;

    @Test
    void proceed() {
        typeService.proceed();
    }
}