package com.quid.kotlin.effective

fun main(){
    val p1 = Person(1, "John", 30)
    val p2 = Person(1, "John", 30)
    val p3 = Person(2, "John", 30)

    println(p1 == p2)
    println(p1 == p3)
    println(p1 === p2)
    println(p1 === p3)

    val set = hashSetOf(p1, p2, p3)
    println(set)
}

data class Person(val id:Long, val name: String, val age: Int){
    val random: Int
        get() = (Math.random() * 100).toInt()

    override fun equals(other: Any?): Boolean {
        if(other === this) return true
        if(other !is Person) return false
        return other.id == this.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}