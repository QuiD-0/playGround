package com.quid.Kotlin.Collections

fun main() {
    val map = mapOf("a" to 1, "b" to 2, "c" to 3)
//    map['d'] = 4

    val mutableMap = mutableMapOf("a" to 1, "b" to 2, "c" to 3)
    mutableMap["d"] = 4
    mutableMap["e"] = 5

    mutableMap.filter { it.value % 2 == 0 }.also { println(it.keys) }


}