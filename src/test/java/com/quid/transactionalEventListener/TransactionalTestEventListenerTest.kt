package com.quid.transactionalEventListener

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Profile

@Profile("local")
@SpringBootTest
class TransactionalTestEventListenerTest{

    @Autowired
    lateinit var transactionalEventListener: TransactionalEventListener

    @Test
    fun successEvent(){
        transactionalEventListener.onEvent(true)
    }
}