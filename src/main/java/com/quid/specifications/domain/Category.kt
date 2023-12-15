package com.quid.specifications.domain

sealed interface Category {
    val name: String
    val code: String
}

fun Category(name: () -> String) = when (name()) {
    "CLOTHING" -> Clothing()
    "SHOES" -> Shoes()
    "ACCESSORIES" -> Accessories()
    "ELECTRONICS" -> Electronics()
    "BEAUTY" -> Beauty()
    else -> throw IllegalArgumentException("Invalid category name")
}

data class Clothing(
    override val name: String = "CLOTHING",
    override val code: String = "A0001"
) : Category

data class Shoes(
    override val name: String = "SHOES",
    override val code: String = "A0002"
) : Category

data class Accessories(
    override val name: String = "ACCESSORIES",
    override val code: String = "A0003"
) : Category

data class Electronics(
    override val name: String = "ELECTRONICS",
    override val code: String = "A0004"
) : Category

data class Beauty(
    override val name: String = "BEAUTY",
    override val code: String = "A0006"
) : Category