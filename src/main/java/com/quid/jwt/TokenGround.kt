package com.quid.jwt

fun main() {
    val header = Header()
    val payload = Payload(
        name = "wodnd101",
        email = "wodnd101@gmail.com"
    )

    val token = Token(
        header = header,
        payload = payload,
        secret = "secret"
    )
    println(token.getToken())
}