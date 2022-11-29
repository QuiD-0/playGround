package com.quid.Kotlin.Basic.classGround

class Person private constructor(val name: String, var age: Int) {
    init {
        if (age < 0) throw IllegalArgumentException("Age must be greater than 0")
    }

    companion object Factory : Log{
        private const val MIN_AGE = 1
        fun of(): Person {
            return Person("QuiD", 0)
        }

        fun of(name: String): Person {
            return Person(name, MIN_AGE)
        }

        fun of(name: String, age: Int): Person {
            return Person(name, age)
        }

        override fun log(message: String) {
            println(message)
        }
    }

    val isAdult: Boolean
        get() = this.age >= 18
}