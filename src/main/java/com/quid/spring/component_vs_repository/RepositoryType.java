package com.quid.spring.component_vs_repository;

import com.quid.specifications.gateway.repository.jpa.ProductEntity;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoryType {

    private final JdbcClient jdbcClient;

    public RepositoryType(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public ProductEntity proceed() {
        return jdbcClient.sql("SELECT p.* from product p where p.id = 999")
                .query(ProductEntity.class).optional().orElseThrow(IllegalArgumentException::new);
    }
}

