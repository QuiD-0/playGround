package com.quid.specifications.gateway.repository.jpa

import org.springframework.data.jpa.domain.Specification
import org.springframework.data.jpa.repository.JpaRepository

interface ProductJpaRepository : JpaRepository<ProductEntity, Long>, Specification<ProductEntity> {
    fun findAll(toSpecification: Specification<ProductEntity>): List<ProductEntity>
}