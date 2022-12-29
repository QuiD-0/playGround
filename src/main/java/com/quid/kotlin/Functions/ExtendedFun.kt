package com.quid.kotlin.functions

fun main() {

    "Hello".lastChar().also { println(it) }

    ("Hello" add "World").also { println(it) }
}

// Extension function
fun String.lastChar(): Char = this[this.length - 1]

// infix function
infix fun String.add(s: String): String = this + s

// inline function
inline fun String.addInline(s: String): String = "$this $s ~!"