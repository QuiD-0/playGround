package com.quid.kotlin.basic

import org.junit.jupiter.api.Test

class Types {

    @Test
    fun test() {
        val num1 = 1
        val num2 = 2L
        val num3 = 3.0

        val toInt = num3.toInt()
        val toLong = num1.toLong()
        val toDouble = num2.toDouble()

        if (num1 is Int) {
            println("num1 is Int")
            val num4 = num1.toLong()
            println("num4 is Long")
        }

        anyFunction(1)
    }

    private fun anyFunction(any: Any) {
        if (any is Any) {
            println("any is Any")
        }
        if (any is String) {
            println("any is String")
        }
    }

    fun unitFun(): Unit {
        println("unitFun")
    }

    fun nothingFun(): Nothing {
        throw Exception("Nothing")
    }

    fun stringInterpolation() {
        val name = "Quid"
        println("Hello, $name!")
    }

    fun trimIndent() {
        val text = """
            |Tell me and I forget.
            |Teach me and I remember.
            |Involve me and I learn.
            |(Benjamin Franklin)
            """.trimIndent()
        println(text)
    }

    fun stringIndexing(): Unit {
        val str = "abc"
        println(str[0])
        println(str.get(1))
    }
}