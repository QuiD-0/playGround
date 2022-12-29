package com.quid.Kotlin.JWT

fun main() {
    val header = Header()
    val payload = Payload()

    val token = Token()
        .header(header)
        .payload(payload)
        .build()
    println(token.getToken())
}