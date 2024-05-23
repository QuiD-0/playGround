package com.quid.transactionalEventListener

import com.quid.specifications.gateway.repository.ProductRepository
import org.springframework.context.ApplicationEvent
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

    data class Event(val id: Long) : ApplicationEvent(id)
}