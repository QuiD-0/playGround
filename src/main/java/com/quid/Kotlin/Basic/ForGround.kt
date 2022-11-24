package com.quid.Kotlin.Basic;

import org.junit.jupiter.api.Test;

class ForGround {

    @Test
    fun test() {
        val nums = listOf(1, 2, 3)
        for (num in nums) {
            println(num)
        }

        for (i in 1..3) {
            println(i)
        }

        IntRange(1, 10).step(2).forEach { println(it) }
    }

}
