package com.quid.transactionalEventListener

import com.quid.specifications.domain.Clothing
import com.quid.specifications.domain.Product
import com.quid.specifications.gateway.repository.ProductRepository
import com.quid.transactionalEventListener.TestEventListener.Event
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Component
class TransactionalEventListener(
    private val applicationEventPublisher: ApplicationEventPublisher,
    private val repository: ProductRepository
) {

    @Transactional
    fun saveProduct(flag: Boolean): Product {
        println("transaction started")
        val product= repository.save(product)
        applicationEventPublisher.publishEvent(Event(product.id!!))
        if (!flag) {
            throw RuntimeException("error")
        }
        return product
    }

    private val product = Product(
        id = 1,
        name = "product",
        description = "description",
        price = 100.0,
        category = Clothing(),
        isDisplayed = true,
        regDate = LocalDateTime.now()
    )

}