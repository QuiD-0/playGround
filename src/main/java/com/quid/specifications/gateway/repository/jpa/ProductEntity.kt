package com.quid.specifications.gateway.repository.jpa

import com.quid.specifications.domain.Category
import com.quid.specifications.domain.Product
import junny.land.xlsx.annotation.Column
import org.hibernate.annotations.Where
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "PRODUCT")
@Where(clause = "IS_DISPLAYED = true")
class ProductEntity(
    @Id
    @Column("ID")
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null,
    @Column("NAME")
    val name: String,
    @Column("DESCRIPTION")
    val description: String,
    @Column("PRICE")
    val price: Int,
    @Column("CATEGORY")
    val category: String,
    @Column("CATEGORY_CODE")
    val categoryCode: String,
    @Column("IS_DISPLAYED")
    val isDisplayed: Boolean,
    @Column("REG_DATE")
    val regDate: LocalDateTime,
) {

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

fun toProductEntity(product: Product) = ProductEntity(
    id = product.id,
    name = product.name,
    description = product.description,
    price = product.price.toInt(),
    category = product.category.name,
    categoryCode = product.category.code,
    isDisplayed = product.isDisplayed,
    regDate = product.regDate
)

