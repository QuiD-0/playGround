package com.quid.Kotlin.Basic.classGround

fun main() {
    Country.KOREA.print()
}

enum class Country(private val capital: String) {

    KOREA("Seoul"),
    JAPAN("Tokyo"),
    CHINA("Beijing"),
    USA("Washington D.C");

    fun print() {
        println("Country $name, Capital $capital")
    }
}