package com.quid.kotlin.Others

class Tailrec {

    fun factorial(n: Int): Int {
        return if (n == 1) n else n * factorial(n - 1)
    }

    tailrec fun factorialTailrec(n: Int, result: Int = 1): Int {
        return if (n == 1) result else factorialTailrec(n - 1, n * result)
    }
}

fun main() {
    val function = Tailrec()
    println(function.factorial(5))
    println(function.factorialTailrec(5))
}
