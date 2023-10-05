package com.quid.kotlin.Others

fun main(){

    (2 powSum 3).also { println(it) }
    2.powSum(3).also { println(it) }

}

private infix fun Int.powSum(x: Int) = this*this + x*x

