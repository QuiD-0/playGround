package com.quid.Kotlin.Others

import com.quid.Kotlin.Basic.classGround.PersonDto

fun main() {

    val (name1, age1) = PersonDto("quid", 20)
    println("name: $name1, age: $age1")

    val name2 = PersonDto("quid", 20).component1()
    val age2 = PersonDto("quid", 20).component2()
    println("name: $name2, age: $age2")

}