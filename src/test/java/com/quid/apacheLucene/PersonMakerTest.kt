package com.quid.apacheLucene

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PersonMakerTest{

    @Test
    fun makePersonWithCount(){
        val count = 5
        val personMaker = PersonMaker(count)
        val result = personMaker.make()
        assertEquals(count, result.size)
    }
}