package com.quid.Kotlin.Basic.classGround

fun main() {
    val out: OuterClass = OuterClass("Seoul")
    out.innerClass.print()
}


class OuterClass(
    private val address: String
) {
    val innerClass: InnerClass = InnerClass("QuiD", 20)

    inner class InnerClass(
        private val name: String,
        private val age: Int,
    ) {
        fun print() {
            println("InnerClass ${this@OuterClass.address}")
        }
    }
}