package com.quid.spring3.jdbcClient;

import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.simple.JdbcClient;

public class JdbcClientConfig {

    public DataSource dataSource() {
        return DataSourceBuilder.create()
            .url("jdbc:mysql://localhost:3306/playground")
            .username("local_user")
            .password("LOCAL_TEST")
            .build();
    }

    public JdbcClient jdbcClient() {
        return JdbcClient.create(dataSource());
    }

}
