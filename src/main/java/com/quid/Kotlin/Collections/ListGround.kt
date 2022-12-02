package com.quid.Kotlin.Collections

fun main() {
    val list1 = listOf(1, 2, 3)
//    list1.add(4)

    val list2 = mutableListOf(1, 2, 3)
    list2.add(4)
    list2.add(5)

    println(list1)
    println(list2)

}