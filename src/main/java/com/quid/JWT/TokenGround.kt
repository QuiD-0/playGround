package com.quid.JWT

fun main() {
    val header = Header()
    val payload = Payload()

    val token = Token()
        .header(header)
        .payload(payload)
        .build()
    println(token.getToken())

    val token2 = Token()
        .header(header)
        .payload(payload)
        .secret("my_secret")
        .build()
    println(token2.getToken())
}