package com.quid.Kotlin.Basic.classGround

fun main() {
    val person = PersonDto("QuiD", 20)
    println(person.name)
    println(person.age)
}


data class PersonDto(val name: String, val age: Int) {
    fun print() {
        println("PersonDto $name $age")
    }
}
