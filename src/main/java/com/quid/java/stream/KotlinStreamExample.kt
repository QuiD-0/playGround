package com.quid.java.stream

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)

    // 시퀀스는 지연 연산을 사용한다.
    val doubledAsSequence = numbers
        .asSequence()
        .map {
            println("Mapping number: $it")
            it * 2
        }
        .filter {
            println("Filtering number: $it")
            it > 5
        }
        .toList()

    // 기본 컬렉션은 즉시 연산 된다.
    val doubled = numbers
        .map {
            println("Mapping number: $it")
            it * 2
        }
        .filter {
            println("Filtering number: $it")
            it > 5
        }
}
