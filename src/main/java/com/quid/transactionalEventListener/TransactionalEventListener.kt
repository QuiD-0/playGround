package com.quid.transactionalEventListener

import com.quid.transactionalEventListener.TestEventListener.Event
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class TransactionalEventListener(
    private val eventListener: TestEventListener
) {

    @Transactional
    fun onEvent(flag: Boolean) {
        println("transaction started")
        eventListener.publishEvent(Event("event"))
        when (flag) {
            true -> println("transaction completed")
            false -> throw IllegalArgumentException("error")
        }
    }

}