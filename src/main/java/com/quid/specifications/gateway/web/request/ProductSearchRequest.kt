package com.quid.specifications.gateway.web.request

import java.time.LocalDateTime

data class ProductSearchRequest(
    val name: String?,
    val description: String?,
    val price: Int?,
    val category: String?,
    val regDate: LocalDateTime?,
) {
}