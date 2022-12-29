package com.quid.Kotlin.JWT

class Token {
    private lateinit var header: Header
    private lateinit var payload: Payload

    fun header(header: Header): Token {
        this.header = header
        return this
    }

    fun payload(payload: Payload): Token {
        this.payload = payload
        return this
    }

    fun build(): Token {
        return this
    }

    fun getToken(): String {
        return header.getEncodedHeader() + "." + payload.getEncodedPayload() + "." + Signature(
            payload,
            header
        ).getSignature()
    }
}