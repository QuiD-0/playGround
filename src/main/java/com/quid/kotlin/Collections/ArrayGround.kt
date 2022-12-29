package com.quid.kotlin.collections

fun main() {
    val array1 = arrayOf(1, 2, 3, 4, 5)

    array1.withIndex().forEach { (idx, value) -> println("idx: $idx, value: $value") }

    array1.filter { it % 2 == 0 }.also { println(it) }

    array1.filter { it % 2 == 0 }.sumOf { it }.also { println(it) }

    array1.filter { it % 2 == 0 }.map { "$it!" }.also { println(it) }

    array1.filter { it % 2 == 0 }.map { "$it!" }.joinToString(" ").also { println(it) }

    array1.filter { customFilter(it, 2) }.also { println(it) }

    array1.filter { customFilter(it, 2) }.map { "$it!" }.groupBy { it.length }.also { println(it) }

    array1.customFilter { it % 2 == 0 }.also { println(it) }
}

private fun <T> Array<T>.customFilter(function: (s: Int) -> Boolean): Any {
    return this.filter { function(it as Int) }
}

fun customFilter(i: Int, num: Int): Boolean {
    return i % num == 0
}
