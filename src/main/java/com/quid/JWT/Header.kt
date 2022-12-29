package com.quid.JWT

import java.util.*


class Header(
    private val alg: String = "HS256",
    private val typ: String = "JWT"
) {

    private fun getHeader(): String {
        return "{\"alg\": \"$alg\", \"typ\": \"$typ\"}"
    }

    fun getEncodedHeader(): String {
        return Base64.getUrlEncoder().withoutPadding().encodeToString(getHeader().toByteArray())
    }
}
