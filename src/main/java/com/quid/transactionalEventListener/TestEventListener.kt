package com.quid.transactionalEventListener

import org.springframework.context.ApplicationEvent
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Component
class TestEventListener {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    fun publishEvent(event: Event) {
        println("publishing event ${event.message}")
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    fun rollbackEvent(event: Event) {
        println("rollback event ${event.message}")
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
    fun completionEvent(event: Event) {
        println("completion event ${event.message}")
    }




    data class Event(val message: String): ApplicationEvent(message) {
        override fun getSource(): String = message
    }
}