package com.quid.specifications.gateway.repository

import com.quid.specifications.domain.Product
import com.quid.specifications.gateway.repository.jpa.ProductEntity
import com.quid.specifications.gateway.repository.jpa.ProductJpaRepository
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

interface ProductRepository {
    fun allBy(specification: Specification<ProductEntity>): List<Product>
    fun byId(id: Long): Product
    fun save(product: Product): Product

    @Repository
    class ProductRepositoryImpl(
        private val repository: ProductJpaRepository
    ) : ProductRepository {
        override fun allBy(specification: Specification<ProductEntity>): List<Product> =
            repository.findAll(specification)
                .map { it.toDomain() }

        override fun byId(id: Long): Product =
            repository.findByIdOrNull(id)?.toDomain()
                ?: throw IllegalArgumentException("Product not found")

        override fun save(product: Product): Product {
            return repository.save(ProductEntity(product)).toDomain()
        }
    }
}
