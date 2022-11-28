package com.quid.Kotlin.Basic.classGround

import org.junit.jupiter.api.Test

class Ground {

    @Test
    fun test() {
        val person = Person.of("Quid", 20)
        println(person.name)
        println(person.age)
        println(person.isAdult)

        val person2 = Person.of()
        println(person2.name)
        println(person2.age)
        println(person2.isAdult)
    }
}