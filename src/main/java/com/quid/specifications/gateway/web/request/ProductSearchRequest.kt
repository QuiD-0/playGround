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
    val regDate: LocalDateTime?,
) {
    fun toSpecification(): Specification<ProductEntity> = Specification<ProductEntity> { root, query, builder ->
        val predicates = mutableListOf<Predicate>()
        name?.let {
            predicates.add(builder.like(root.get("name"), "%$it%"))
        }
        description?.let {
            predicates.add(builder.like(root.get("description"), "%$it%"))
        }
        price?.let {
            predicates.add(builder.greaterThanOrEqualTo(root.get("price"), it))
        }
        category?.let {
            predicates.add(builder.equal(root.get<String>("category"), it))
        }
        regDate?.let {
            predicates.add(builder.greaterThanOrEqualTo(root.get("regDate"), it))
        }
        builder.and(*predicates.toTypedArray())
    }
}