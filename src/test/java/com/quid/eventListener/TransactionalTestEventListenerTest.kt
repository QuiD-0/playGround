package com.quid.eventListener

import com.quid.specifications.domain.Product
import com.quid.specifications.gateway.repository.ProductRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
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

    lateinit var product : Product

    @Test
    @Rollback(false)
    @Transactional
    fun successEvent(){
        assertDoesNotThrow { product = transactionalEventListener.saveProduct(true) }
    }

    @AfterTransaction
    fun afterTransaction(){
        val find = productRepository.byId(product.id!!)
            .also { println("After transaction: $it") }
        assertEquals("product", find.name)
    }
}