package com.quid.apacheLucene

import org.junit.jupiter.api.Test

class LuceneTest{

    @Test
    fun indexingWithLucene(){
        val path = "src/test/resources/index"
        val lucene = Lucene(path)
        val personMaker = PersonMaker(5)
        val data = personMaker.make()
        lucene.indexing(data)
    }

    @Test
    fun searchWithLucene(){
        val path = "src/test/resources/index"
        val lucene = Lucene(path)
        lucene.search("Person 3")
            .also { println(it) }
    }
}