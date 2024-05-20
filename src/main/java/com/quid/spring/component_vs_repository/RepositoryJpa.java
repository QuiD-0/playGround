package com.quid.spring.component_vs_repository;

import com.quid.specifications.gateway.repository.jpa.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryJpa extends JpaRepository<ProductEntity, Long>{
    default ProductEntity proceed() {
        return findById(999L).orElseThrow(IllegalArgumentException::new);
    }
}
