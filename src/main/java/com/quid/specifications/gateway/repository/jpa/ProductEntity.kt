package com.quid.specifications.gateway.repository.jpa

import com.quid.specifications.domain.Category
import com.quid.specifications.domain.Product
import jakarta.persistence.*
import org.hibernate.annotations.Where
import java.time.LocalDateTime
import jakarta.persistence.GenerationType.IDENTITY

@Entity
@Table(name = "PRODUCT")
@Where(clause = "IS_DISPLAYED = true")
class ProductEntity(
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null,
    @Column(name = "NAME")
    val name: String,
    @Column(name = "DESCRIPTION")
    val description: String,
    @Column(name = "PRICE")
    val price: Int,
    @Column(name = "CATEGORY")
    val category: String,
    @Column(name = "CATEGORY_CODE")
    val categoryCode: String,
    @Column(name = "IS_DISPLAYED")
    val isDisplayed: Boolean,
    @Column(name = "REG_DATE")
    val regDate: LocalDateTime,
) {
    constructor(product: Product): this(
        id = product.id,
        name = product.name,
        description = product.description,
        price = product.price.toInt(),
        category = product.category.name,
        categoryCode = product.category.code,
        isDisplayed = product.isDisplayed,
        regDate = product.regDate
    )

    fun toDomain() = Product(
        id = id,
        name = name,
        description = description,
        price = price.toDouble(),
        category = Category{ category },
        isDisplayed = isDisplayed,
        regDate = regDate
    )

}
