package com.quid.kotlin.functions

fun main() {

    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")

    fruits.all { it == "apple" }.also { println(it) }

    fruits.any { it == "apple" }.also { println(it) }

    fruits.count { it == "apple" }.also { println(it) }

    fruits.find { it == "apple" }.also { println(it) }

    fruits.filter { it == "apple" }.also { println(it) }

    fruits.filterNot { it == "apple" }.also { println(it) }

    fruits.first { it == "apple" }.also { println(it) }

    fruits.firstOrNull { it == "apple" }.also { println(it) }

    fruits.last { it == "apple" }.also { println(it) }

    fruits.distinctBy { it.length }.sorted().also { println(it) }

}