package com.quid.apacheLucene

import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

class LuceneTest {
    private val log = LoggerFactory.getLogger(this::class.java)
    private val path = "src/test/resources/index"
    private val lucene = Lucene(path)

    @Test
    fun indexingWithLucene() {
        val personMaker = PersonMaker(1_000)
        repeat(100) {
            personMaker.make()
                .also { lucene.indexing(it) }
        }
    }

    @Test
    fun searchWithLucene() {
        lucene.search("Person*", 10)
            .also { log.info("$it") }
    }
}