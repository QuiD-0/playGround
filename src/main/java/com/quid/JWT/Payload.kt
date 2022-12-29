package com.quid.JWT

import java.util.*

class Payload(
    private var sub: String = "QUID_TOKEN",
    private var name: String = "QuiD",
    private var email: String = "wodnd101@naver.com",
    private var iat: Long = System.currentTimeMillis() / 1000,
    private var exp: Long = iat + 60 * 60 * 24 * 7
) {
    fun sub(sub: String): Payload {
        this.sub = sub
        return this
    }

    fun name(name: String): Payload {
        this.name = name
        return this
    }

    fun email(email: String): Payload {
        this.email = email
        return this
    }

    fun iat(iat: Long): Payload {
        this.iat = iat
        return this
    }

    fun exp(exp: Long): Payload {
        this.exp = exp
        return this
    }

    fun build(): Payload {
        return this
    }

    fun getPayload(): String {
        return "{\"sub\":\"$sub\",\"name\":\"$name\",\"email\":\"$email\",\"iat\":$iat,\"exp\":$exp}"
    }

    fun getEncodedPayload(): String {
        return Base64.getUrlEncoder().withoutPadding().encodeToString(getPayload().toByteArray())
    }
}
