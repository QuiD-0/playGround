package com.quid.kotlin.effective

fun main(){

    val password = Password("123456")
    val password2 = Password("123456")

    println(password.checkLength())
    println(password == password2)
}

@JvmInline
value class Password(private val value: String){
    fun checkLength() = value.length > 6
}

