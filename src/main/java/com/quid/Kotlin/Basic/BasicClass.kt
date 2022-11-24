package com.quid.Kotlin.Basic


class BasicClass(private val name: String, private val age: Int) {
    override fun toString() = "name = $name, age = $age"

    fun getAge(): Int {
        return age
    }

    fun getName(): String {
        return name
    }

    operator fun plus(basicClass: BasicClass) = BasicClass(name + basicClass.name, age + basicClass.age)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BasicClass

        if (name != other.name) return false
        if (age != other.age) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + age
        return result
    }

}