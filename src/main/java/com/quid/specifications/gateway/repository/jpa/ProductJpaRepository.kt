package com.quid.specifications.gateway.repository.jpa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface ProductJpaRepository : JpaRepository<ProductEntity, Long>, JpaSpecificationExecutor<ProductEntity> {
}