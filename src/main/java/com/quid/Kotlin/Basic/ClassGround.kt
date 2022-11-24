package com.quid.Kotlin.Basic

import org.junit.jupiter.api.Test

class ClassGround {

    @Test
    fun test() {
        val basicClass = BasicClass("Quid", 18)
        val basicClass2 = BasicClass("Quid", 18)

        basicClass.toString()
        println("age = ${basicClass.getAge()}")
        println("name = ${basicClass.getName()}")

        val b = basicClass == basicClass2
        println("b = $b")

        println(basicClass + basicClass2)
    }
}