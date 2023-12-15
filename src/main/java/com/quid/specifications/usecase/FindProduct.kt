package com.quid.specifications.usecase

import com.quid.specifications.domain.Product
import com.quid.specifications.gateway.repository.ProductRepository
import com.quid.specifications.gateway.web.request.ProductSearchRequest
import org.springframework.stereotype.Service

interface FindProduct {
    fun allBy(condition: ProductSearchRequest): List<Product>
    fun byId(id: Long): Product

    @Service
    class FindProductUseCase(
        private val productRepository: ProductRepository
    ): FindProduct {
        override fun allBy(condition: ProductSearchRequest): List<Product> {
            TODO()
        }

        override fun byId(id: Long): Product {
            TODO()
        }
    }
}
