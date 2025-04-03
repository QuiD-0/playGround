package com.quid.springboot.jdbcClient;

import com.quid.specifications.domain.Product;
import com.quid.specifications.gateway.repository.jpa.ProductEntity;
import java.util.List;

import org.springframework.jdbc.core.simple.JdbcClient;

public class JdbClientService {

    private final JdbcClientConfig jdbcClientConfig = new JdbcClientConfig();
    private final JdbcClient jdbcClient = jdbcClientConfig.jdbcClient();

    public List<Product> getProducts() {
        return jdbcClient.sql("SELECT * FROM product")
            .query(ProductEntity.class).list().stream().map(ProductEntity::toDomain).toList();
    }

}
