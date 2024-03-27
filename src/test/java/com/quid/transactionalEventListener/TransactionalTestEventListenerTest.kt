package com.quid.transactionalEventListener

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TransactionalTestEventListenerTest{

    @Autowired
    lateinit var transactionalEventListener: TransactionalEventListener

    @Test
    fun successEvent(){
        transactionalEventListener.onEvent(true)
    }

    @Test
    fun failEvent(){
        assertThrows<RuntimeException>{
            transactionalEventListener.onEvent(false)
        }
    }
}