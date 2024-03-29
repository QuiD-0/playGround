package com.quid.apacheLucene

import org.apache.lucene.analysis.standard.StandardAnalyzer
import org.apache.lucene.index.DirectoryReader
import org.apache.lucene.index.IndexWriter
import org.apache.lucene.index.IndexWriterConfig
import org.apache.lucene.index.Term
import org.apache.lucene.search.IndexSearcher
import org.apache.lucene.search.TermQuery
import org.apache.lucene.store.FSDirectory
import java.io.File


data class Lucene(val path: String) {
    private val directory = fsDirectory()
    private val config = indexWriterConfig()

    fun indexing(dataList: List<PersonData>) {
        IndexWriter(directory, config).use {
            dataList.map { data -> data.toDocument() }
                .let { docs -> it.addDocuments(docs) }
        }
    }

    fun search(find: String) {
        val indexSearcher = IndexSearcher(DirectoryReader.open(directory))
        val nameQuery = TermQuery(Term("name", find))
        val result = indexSearcher.search(nameQuery, 10)

        result.scoreDocs.map { scoreDoc ->
            indexSearcher.doc(scoreDoc.doc).let { doc ->
                println("id: ${doc.get("id")}")
                println("name: ${doc.get("name")}")
                println("city: ${doc.get("city")}")
                println("description: ${doc.get("description")}")
            }
        }
    }

    private fun indexWriterConfig() = IndexWriterConfig(StandardAnalyzer())

    private fun fsDirectory(): FSDirectory? =
        FSDirectory.open(File(path).toPath())

}