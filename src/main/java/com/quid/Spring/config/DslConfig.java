package com.quid.Spring.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import javax.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DslConfig {

    @Bean
    JPAQueryFactory jpaQueryFactory(EntityManager em){
        return new JPAQueryFactory(em);
    }

}
