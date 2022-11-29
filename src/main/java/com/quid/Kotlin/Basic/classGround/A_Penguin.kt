package com.quid.Kotlin.Basic.classGround

class A_Penguin(override val name: String) : Animal {

    override fun eat() {
        super.eat()
        println("I am eating fish")
    }
}