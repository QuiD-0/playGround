package com.quid.resilience4j

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/test")
class Controller(
    private val client: DemoClient
) {

    @GetMapping
    fun call(): String {
        return client.getData()
    }

    @GetMapping("/random")
    fun randomSuccess(): String {
        val nextInt = Random().nextInt(1000)
        return if (nextInt < 500) {
            "Success: $nextInt"
        } else {
            throw RuntimeException("Failure: $nextInt")
        }
    }
}
