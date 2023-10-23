package com.quid.kotlin.effective

fun main() {

    val result: Result<String> = getRandomResult()

    when (result) {
        is Success -> result.data
        is Failure -> result.exception.message
    }

    println(result)
}

fun getRandomResult(): Result<String> {
    return if (System.currentTimeMillis() % 2 == 0L) {
        Success("Success")
    } else {
        Failure(Exception("Failure"))
    }
}

sealed class Result<out T>
data class Success<out T>(val data: T) : Result<T>()
data class Failure(val exception: Exception) : Result<Nothing>()