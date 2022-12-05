package com.quid.Kotlin.Others

/**
 *
 * 사용하지 않는게 좋음!
 *
 */

fun main() {
    val arr = mutableListOf(1, 2, 3, 4, 5)
    run {
        arr.forEach { num ->
            if (num == 3) {
                return@run
            }
            println(num)
        }
    }

    arr.forEach { num ->
        if (num == 3) {
            return@forEach
        }
        println(num)
    }

    loop@ for (i in 1..10) {
        for (j in 1..10) {
            if (j == 5) {
                break@loop
            }
            println("i: $i, j: $j")
        }
    }
}