package com.quid.kotlin.basic

import org.junit.jupiter.api.Test

class FunGround {

    fun max(a: Int, b: Int): Int = if (a > b) a else b

    fun repeat(str: String, n: Int = 3, useNewLine: Boolean = false) {
        for (i in 1..n) {
            print(str)
            if (useNewLine) {
                println()
            }
        }
    }

    fun printAll(vararg messages: String) {
        for (m in messages) {
            println(m)
        }
    }

    @Test
    fun test() {
        repeat("Hello", useNewLine = true)
        printAll("Hello", "World", "Kotlin")

        val nums = arrayOf("A", "B", "C")
        printAll(*nums)
    }

}