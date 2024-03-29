package com.quid.apacheLucene

import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

class LuceneTest{
    private val logger = LoggerFactory.getLogger(this::class.java)

    @Test
    fun indexingWithLucene(){
        val path = "src/test/resources/index"
        val lucene = Lucene(path)
        val personMaker = PersonMaker(10)
        repeat(10){
            personMaker.make()
                .also { lucene.indexing(it) }
                .also { logger.info("Indexing completed") }
        }
    }

    @Test
    fun searchWithLucene(){
        val path = "src/test/resources/index"
        val lucene = Lucene(path)
        lucene.search("Person 3", 10000)
            .also { println(it) }
    }
}