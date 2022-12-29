package com.quid.Kotlin.Builder

fun main() {
    TokenUtil().createToken().let(TokenUtil()::print)
}