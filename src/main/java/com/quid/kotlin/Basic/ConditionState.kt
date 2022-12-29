package com.quid.kotlin.basic

import org.junit.jupiter.api.Test

class ConditionState() {

    @Test
    fun test() {
        val a = 1
        val b = 2
        val max = if (a > b) a else b
        println("max = $max")

        val max2 = if (a > b) {
            println("Choose a")
            a
        } else {
            println("Choose b")
            b
        }
        println("max2 = $max2")

        when (1) {
            1 -> println("x == 1")
            2 -> println("x == 2")
            else -> {
                println("x is neither 1 nor 2")
            }
        }

        when (2) {
            1, 2 -> println("y == 1 or y == 2")
            else -> println("otherwise")
        }

        val z = 3
        when (z) {
            in 1..10 -> println("z is in the range")
            !in 10..20 -> println("z is outside the range")
            else -> println("none of the above")
        }

        val validNumbers = arrayOf(1, 2, 3)
        when (z) {
            in validNumbers -> println("z is valid")
            in 1..10 -> println("z is in the range")
            else -> println("none of the above")
        }

        when ("abc") {
            is String -> println("obj is String")
            !is String -> println("obj is not String")
            else -> println("otherwise")
        }

        when (1) {
            1, 2 -> println("obj2 == 1 or obj2 == 2")
            else -> println("otherwise")
        }

        when (3) {
            1, 2 -> println("obj3 == 1 or obj3 == 2")
            else -> println("otherwise")
        }
    }

    @Test
    fun untilTest() {
        for (i in 1..10) {
            println(i)
        }

        for (i in 1 until 10 step 2) {
            println(i)
        }

        for (i in 10 downTo 1) {
            println(i)
        }
    }
}