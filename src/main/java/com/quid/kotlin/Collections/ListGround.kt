package com.quid.kotlin.collections

fun main() {
    val list1 = listOf(1, 2, 3)
//    list1.add(4)

    val list2 = mutableListOf(1, 2, 3)
    list2.add(4)
    list2.add(5)

    println(list1)
    println(list2)

    val list3 =
        listOf(listOf(1, 2, 3, 4), listOf(5, 6, 7, 8), listOf(9, 10, 11, 12), listOf(1, 2, 3, 4))
    println(list3)
    println(list3.flatten())
    println(list3.flatten().distinct())


}

