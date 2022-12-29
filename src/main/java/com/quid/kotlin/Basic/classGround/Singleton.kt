package com.quid.kotlin.basic.classGround

object Singleton {
    var name: String = "QuiD"
    var age: Int = 0

    override fun toString(): String {
        return "Singleton(name='$name', age=$age)"
    }
}