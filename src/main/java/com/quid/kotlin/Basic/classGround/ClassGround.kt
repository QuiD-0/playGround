package com.quid.kotlin.basic.classGround

import com.quid.kotlin.basic.BasicClass
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

        Singleton.name  = "Quid"
        println(Singleton)
    }
}