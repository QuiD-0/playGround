package com.quid.Kotlin.Builder

class Token {
    lateinit var type: String
    lateinit var value: String
    lateinit var user: String

    fun type(type: String): Token {
        this.type = type
        return this
    }

    fun value(value: String): Token {
        this.value = value
        return this
    }

    fun user(user: String): Token {
        this.user = user
        return this
    }

    fun build(): Token {
        return this
    }
}