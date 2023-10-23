package com.quid.kotlin.effective

fun main() {
    Companion(20).also { println(it.age) }
    Companion.name("QuiD").also { println(it) }
}

class Companion(
    val age: Int
) {

    companion object : AbstractClass() {
        override fun name(name: String): String {
            return name
        }
    }
}

abstract class AbstractClass {
    abstract fun name(name: String): String
}