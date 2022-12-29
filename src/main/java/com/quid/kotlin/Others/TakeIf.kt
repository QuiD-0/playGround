package com.quid.kotlin.others

fun main() {

    val arr = mutableListOf(1, 2, 3, 4, 5)
    arr.takeIf { it.size > 3 }?.let { println(it) }

    arr.takeUnless { it.size > 3 }?.let { println(it) }

}