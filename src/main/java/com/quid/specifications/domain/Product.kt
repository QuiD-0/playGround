package com.quid.specifications.domain

import java.time.LocalDateTime

data class Product(
    val id: Long? = null,
    val name: String,
    val description: String,
    val price: Double,
    val category: Category,
    val isDisplayed: Boolean = true,
    val regDate: LocalDateTime = LocalDateTime.now()
) {
    init {
        require(name.isNotBlank()) { "Product name cannot be blank" }
        require(description.isNotBlank()) { "Product description cannot be blank" }
        require(price > 0) { "Product price must be greater than 0" }
    }

}
