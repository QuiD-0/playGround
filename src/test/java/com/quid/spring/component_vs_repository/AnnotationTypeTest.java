package com.quid.spring.component_vs_repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class AnnotationTypeTest {

    @Autowired
    private ComponentType componentType;

    @Autowired
    private RepositoryType repositoryType;

    @Autowired
    private RepositoryJpa repositoryJpa;

    @Test
    void proceedWithComponent() {
        assertThrows(IllegalArgumentException.class, componentType::proceed);
    }

    @Test
    void proceedWithRepository() {
        assertThrows(InvalidDataAccessApiUsageException.class, repositoryType::proceed);
    }

    @Test
    void proceed() {
        assertThrows(InvalidDataAccessApiUsageException.class, repositoryJpa::proceed);
    }
}