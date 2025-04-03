package com.quid.springboot.component_vs_repository;

import com.quid.specifications.gateway.repository.jpa.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface RepositoryJpa extends JpaRepository<ProductEntity, Long> {

    @Transactional(readOnly = true)
    default ProductEntity proceed() {
        return findById(999L).orElseThrow(IllegalArgumentException::new);
    }
}
