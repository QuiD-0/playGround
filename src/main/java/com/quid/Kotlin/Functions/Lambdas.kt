package com.quid.Kotlin.Functions

fun main() {
    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    isApple(fruits[0]).also { println(it) }

    filterFruits(fruits) { it == "apple" }
}

fun isApple(name: String): Boolean = name == "apple"

private fun filterFruits(fruits: List<String>, filter: (String) -> Boolean): List<String> {
    return fruits.filter(predicate = filter)
}

