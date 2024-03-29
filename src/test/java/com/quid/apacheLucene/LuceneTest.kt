package com.quid.apacheLucene

import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

class LuceneTest{
    private val logger = LoggerFactory.getLogger(this::class.java)
    private val path = "src/test/resources/index"
    private val lucene = Lucene(path)

    @Test
    fun indexingWithLucene(){
        val personMaker = PersonMaker(10)
        repeat(10){
            personMaker.make()
                .also { lucene.indexing(it) }
                .also { logger.info("Indexing completed") }
        }
    }

    @Test
    fun searchWithLucene(){
        lucene.search("Person 3", 10000)
            .also { println(it) }
    }
}