package com.quid.Kotlin.Basic

import org.junit.jupiter.api.Test

class ValAndVar {

    @Test
    fun test() {
        val a = 1
        val b = 2
//        b = 3 // Error
        println("a = $a, b = $b")

        var x = 5
        x = 1
        println("x = $x")

        val c = 3
        val d = 4L
        val e = c + d
        println("e = $e")

        val name = "Quid"
        println("Hello, $name!")
    }

    @Test
    fun nullTest() {
        var insertNUll: Long? = 1L
        insertNUll = null
    }

}