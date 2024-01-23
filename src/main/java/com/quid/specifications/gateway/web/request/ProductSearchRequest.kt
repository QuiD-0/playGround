package com.quid.specifications.gateway.web.request

import com.quid.specifications.gateway.repository.jpa.ProductEntity
import org.springframework.data.jpa.domain.Specification
import java.time.LocalDateTime
import javax.persistence.criteria.Predicate

data class ProductSearchRequest(
    val name: String?,
    val description: String?,
    val price: Int?,
    val category: String?,
    val categoryCode: String?,
    val regDate: LocalDateTime?,
) {
    fun toSpecification(): Specification<ProductEntity> = Specification<ProductEntity> { root, query, builder ->
        mutableListOf<Predicate>().apply {
            name?.let { add(builder.equal(root.get<String>("name"), it)) }
            description?.let { add(builder.equal(root.get<String>("description"), it)) }
            price?.let { add(builder.equal(root.get<Int>("price"), it)) }
            category?.let { add(builder.equal(root.get<String>("category"), it)) }
            regDate?.let { add(builder.equal(root.get<LocalDateTime>("regDate"), it)) }
            categoryCode?let { add(builder.equal(root.get<String>("categoryCode"), it)) }
            query.orderBy(builder.desc(root.get<LocalDateTime>("regDate")))
        }.let { builder.and(*it.toTypedArray()) }

    }
}