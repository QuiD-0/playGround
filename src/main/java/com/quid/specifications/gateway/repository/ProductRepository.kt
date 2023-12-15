package com.quid.specifications.gateway.repository

import com.quid.specifications.domain.Product
import com.quid.specifications.gateway.repository.jpa.ProductJpaRepository
import com.quid.specifications.gateway.web.request.ProductSearchRequest
import org.springframework.stereotype.Repository

interface ProductRepository {
    fun allBy(condition: ProductSearchRequest): List<Product>
    fun byId(id: Long): Product

    @Repository
    class ProductRepositoryImpl(
        private val productJpaRepository: ProductJpaRepository
    ): ProductRepository {
        override fun allBy(condition: ProductSearchRequest): List<Product> {
            TODO()
        }

        override fun byId(id: Long): Product {
            TODO()
        }
    }
}
