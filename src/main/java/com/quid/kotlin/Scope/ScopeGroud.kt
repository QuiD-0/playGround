package com.quid.kotlin.scope

import com.quid.kotlin.basic.classGround.Person

fun main() {
    // run
    val person = Person.of().run {
        age = 20
        this
    }

    // apply
    val person2 = Person.of().apply {
        this.age = 20
    }

    // let
    val person3 = Person.of().let {
        it.age = 20
        it
    }

    // also
    val person4 = Person.of().also {
        it.age = 20
    }

    // with
    val person5 = with(Person.of()) {
        age = 20
        this
    }

}