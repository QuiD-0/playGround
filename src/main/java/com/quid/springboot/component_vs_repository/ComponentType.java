package com.quid.springboot.component_vs_repository;

import com.quid.specifications.gateway.repository.jpa.ProductEntity;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ComponentType {

    private final JdbcClient jdbcClient;

    public ComponentType(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Transactional(readOnly = true)
    public ProductEntity proceed() {
        return jdbcClient.sql("SELECT p.* from product p where p.id = 999")
                .query(ProductEntity.class).optional().orElseThrow(IllegalArgumentException::new);
    }
}
