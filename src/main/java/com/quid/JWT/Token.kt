package com.quid.JWT

class Token(
    private val header: Header,
    private val payload: Payload,
    private val secret: String = "default_secret",
) {
    fun getToken(): String {
        return header.getEncodedHeader() + "." + payload.getEncodedPayload() + "." + Signature(
            payload,
            header,
            secret
        ).getSignature()
    }
}