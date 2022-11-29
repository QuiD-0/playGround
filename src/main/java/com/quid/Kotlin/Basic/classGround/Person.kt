package com.quid.Kotlin.Basic.classGround

class Person private constructor(val name: String, var age: Int) {
    init {
        if (age < 0) throw IllegalArgumentException("Age must be greater than 0")
    }

    companion object {
        fun of(): Person {
            return Person("QuiD", 0)
        }

        fun of(name: String, age: Int): Person {
            return Person(name, age)
        }
    }

    val isAdult: Boolean
        get() = this.age >= 18
}