package com.quid.Kotlin.Functional

fun main() {
    val set1 = setOf(1, 2, 3)
    val set2 = mutableSetOf(1, 2, 3, 1, 3)
    set2.add(4)
    set2.add(5)
    println(set1)
    println(set2)
}