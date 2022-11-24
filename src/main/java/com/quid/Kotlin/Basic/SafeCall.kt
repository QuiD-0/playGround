package com.quid.Kotlin.Basic

import org.junit.jupiter.api.Test

class SafeCall {

    @Test
    fun test() {
        val a: String? = "abc"
        val length: Int? = a?.length
        println("length = $length")
        val i = a?.length ?: -1
        println("i = $i")
        a!!.length

        val b: String? = null

        a?.run { println("a is not null") }
        b ?: run { println("b is null") }

        val c = a?.length ?: b?.length ?: -1
        println("c = $c")

        a?.startsWith("a") ?: throw IllegalArgumentException("a is null")
    }

}