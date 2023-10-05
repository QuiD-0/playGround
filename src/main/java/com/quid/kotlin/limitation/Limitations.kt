package com.quid.kotlin.limitation

fun main() {

    val stack = CustomStack(listOf(1, 2, 3, 4, 5))

    stack.pop(1).also { println(it) }
}

class CustomStack<T>(
    private var list: List<T> = mutableListOf()
){
    fun pop(num : Int) : List<T> {
        require(list.isNotEmpty())
        check(list.isNotEmpty())
        val ret = list.take(num)
        list = list.drop(num)
        return ret
    }

}
