package com.quid.Kotlin.Builder

class TokenUtil {
    fun createToken(): Token {
        return Token().type("type").value("value").user("user").build()
    }

    fun print(token: Token) {
        println(token.type)
        println(token.value)
        println(token.user)
    }
}