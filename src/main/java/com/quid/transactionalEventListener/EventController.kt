package com.quid.transactionalEventListener

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/event")
class EventController(
    private val transactionalEventListener: TransactionalEventListener
) {

    @GetMapping("/success")
    fun successEvent() {
        transactionalEventListener.saveProduct(true)
    }

    @GetMapping("/fail")
    fun failEvent() {
        transactionalEventListener.saveProduct(false)
    }
}