package com.quid.Kotlin.Basic

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
            val num4 = num1 as Long
            println("num4 is Long")
        }
    }

    @Test
    fun anyFunction() {
        val any = 1
        if (any is Any) {
            println("any is Any")
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