package com.quid.kotlin.Basic

class Nothings {
    fun infinityLoop(): Nothing{
        while(true){
            println("HELLO WORLD!")
        }
    }

    fun fail(message: String): Nothing {
        throw IllegalArgumentException(message)
    }
}

fun main() {
    Nothings().infinityLoop()
}