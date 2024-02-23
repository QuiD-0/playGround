package com.quid.template.api

import org.springframework.http.HttpStatus

interface HttpStatusSelector {
    operator fun invoke(ex: () -> Exception): HttpStatus

    class HttpStatusSelectorImpl : HttpStatusSelector {
        override fun invoke(ex: () -> Exception): HttpStatus =
            when (ex) {
                is IllegalArgumentException -> HttpStatus.BAD_REQUEST
                is NoSuchElementException -> HttpStatus.NOT_FOUND
                is IllegalStateException -> HttpStatus.CONFLICT
                else -> HttpStatus.INTERNAL_SERVER_ERROR
            }
    }

    companion object: HttpStatusSelector by HttpStatusSelectorImpl()

}
