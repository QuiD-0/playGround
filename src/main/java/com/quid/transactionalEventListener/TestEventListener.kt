package com.quid.transactionalEventListener

import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Component
class TestEventListener {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    fun publishEvent(event: Event) {
        println("publishing event ${event.message}")
    }

    data class Event(val message: String)
}