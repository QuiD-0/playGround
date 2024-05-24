package com.quid.eventListener

import com.quid.specifications.gateway.repository.ProductRepository
import org.springframework.context.ApplicationEvent
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Component
class TestEventListener(
    private val productRepository: ProductRepository
) {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    fun publishEvent(event: Event) {
        productRepository.byId(event.id)
            .also { println("Publish event: $it") }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    fun rollbackEvent(event: Event) {
        productRepository.byId(event.id)
            .also { println("Rollback event: $it") }
    }

    @EventListener
    fun syncEvent(event: Event2){
        println("Sync event $event")
    }

    @Async
    @EventListener
    fun asyncEvent(event: Event2){
        println("Async event $event")
    }

    data class Event(val id: Long) : ApplicationEvent(id)
    class Event2
}