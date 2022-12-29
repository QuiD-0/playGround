package com.quid.Kotlin.JWT

import java.util.*
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec


class Signature(
    private val payload: Payload,
    private var header: Header,
    private var secret: String,
) {

    fun getSignature(): String {
        val mac = getMac(header.getEncodedHeader() + "." + payload.getEncodedPayload())
        return hashing(mac)
    }

    private fun getMac(msg: String): ByteArray {
        val sha256_HMAC = Mac.getInstance("HmacSHA256")
        val secret_key = SecretKeySpec(secret.encodeToByteArray(), "SHA256")
        sha256_HMAC.init(secret_key)
        return sha256_HMAC.doFinal(msg.toByteArray())
    }

    private fun hashing(bt: ByteArray): String {
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bt)
    }

}