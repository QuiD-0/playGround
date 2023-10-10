package com.quid.kotlin.effective

import java.util.UUID

fun main(){
    val dataObjectList = makeObject(10)
    val dataObjectList2 = makeObject(10)

    val map = dataObjectList
        .asSequence()
        .filter { it.number % 2 == 0 }
        .map { it.double() }
        .map { println("sequence1 ${it.number}"); it }
        .forEach { println("sequence2 ${it.number}") }


    dataObjectList2
        .filter { it.number % 2 == 0 }
        .map { it.double() }
        .map { println("list1 ${it.number}"); it }
        .forEach { println("list2 ${it.number}") }

}

data class DataObject(
    val id: UUID = UUID.randomUUID(),
    val number: Int,
){
    fun double(): DataObject {
        return this.copy(number = this.number * 2)
    }
}

private fun makeObject(num: Int): List<DataObject> {
    return (0 until num).map { DataObject(number = it) }
}