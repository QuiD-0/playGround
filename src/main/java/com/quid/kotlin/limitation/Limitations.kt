package com.quid.kotlin.limitation

fun main() {

    val stack = CustomStack(listOf(1, 2, 3, 4, 5))

    stack.pop(1).also { println(it) }
    val num: Int? = stack.peek()
    requireNotNull(num) { "num is null" }
    // smart cast
    num.also { println(it) }
}

class CustomStack<T>(
    private var list: List<T> = mutableListOf()
){
    private val isEmpty : Boolean
        get() = list.isEmpty()

    fun peek() : T? = list.firstOrNull()

    fun pop(num : Int) : List<T> {
        require(num > 0) { "num must be positive" }
        check(!isEmpty) { "list is empty" }
        val ret = list.take(num)
        list = list.drop(num)
        return ret
    }

}
