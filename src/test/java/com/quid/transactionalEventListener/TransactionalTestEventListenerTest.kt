package com.quid.transactionalEventListener

import com.quid.specifications.gateway.repository.ProductRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.transaction.AfterTransaction
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class TransactionalTestEventListenerTest{

    @Autowired
    lateinit var transactionalEventListener: TransactionalEventListener

    @Autowired
    lateinit var productRepository: ProductRepository

    @Test
    @Rollback(false)
    @Transactional
    fun successEvent(){
        assertDoesNotThrow { transactionalEventListener.onEvent(true) }
    }

    @AfterTransaction
    fun afterTransaction(){
        val product = productRepository.byId(43)
            .also { println("After transaction: $it") }
        assertEquals("product", product.name)
    }
}