package com.quid.kotlin.basic

import org.junit.jupiter.api.Test

interface InterfaceGround {
    fun test()

    class A : InterfaceGround {
        override fun test() {
            println("A")
        }
    }

    class InterfaceGroundImpl : InterfaceGround {
        override fun test() = println("test")

        @Test
        fun run() {
            val interfaceGroundImpl = InterfaceGroundImpl()
            interfaceGroundImpl.test()
            val a = A()
            a.test()
        }

    }
}