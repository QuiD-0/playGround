package com.quid.JWT

import java.util.*


class Header(
    private var alg: String = "HS256",
    private var typ: String = "JWT"
) {
    fun alg(alg: String): Header {
        this.alg = alg
        return this
    }

    fun typ(typ: String): Header {
        this.typ = typ
        return this
    }

    fun build(): Header {
        return this
    }

    fun getHeader(): String {
        return "{\"alg\": \"$alg\", \"typ\": \"$typ\"}"
    }

    fun getEncodedHeader(): String {
        return Base64.getUrlEncoder().withoutPadding().encodeToString(getHeader().toByteArray())
    }
}
