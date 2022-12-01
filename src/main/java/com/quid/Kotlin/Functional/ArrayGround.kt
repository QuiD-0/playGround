package com.quid.Kotlin.Functional

fun main() {
    val array1 = arrayOf(1, 2, 3, 4, 5)

    array1.withIndex().forEach { (idx, value) -> println("idx: $idx, value: $value") }

    array1.filter { it % 2 == 0 }.also { println(it) }

    array1.filter { it % 2 == 0 }.sumOf { it }.also { println(it) }

    array1.filter { it % 2 == 0 }.map { "$it!" }.also { println(it) }

    array1.filter { it % 2 == 0 }.map { "$it!" }.joinToString(" ").also { println(it) }

}