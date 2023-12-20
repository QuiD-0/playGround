package com.quid.specifications.gateway.web

import com.quid.specifications.domain.Product
import com.quid.specifications.gateway.web.request.ProductSearchRequest
import com.quid.specifications.usecase.FindProduct
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/product")
class SpecificationApiController(
    private val findProduct: FindProduct
) {

    @GetMapping("/search")
    fun searchProduct(request: ProductSearchRequest): List<Product> =
        findProduct.allBy(request)
}