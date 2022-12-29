package com.quid.jwt

import java.util.*

class Payload(
    private val sub: String = "QUID_TOKEN",
    private val name: String = "QuiD",
    private val email: String = "wodnd101@naver.com",
    private val iat: Long = System.currentTimeMillis() / 1000,
    private val exp: Long = iat + 60 * 60 * 24 * 7
) {

    private fun getPayload(): String {
        return "{\"sub\":\"$sub\",\"name\":\"$name\",\"email\":\"$email\",\"iat\":$iat,\"exp\":$exp}"
    }

    fun getEncodedPayload(): String {
        return Base64.getUrlEncoder().withoutPadding().encodeToString(getPayload().toByteArray())
    }
}
