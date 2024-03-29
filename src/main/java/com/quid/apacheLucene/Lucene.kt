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

    fun indexing(dataList: List<PersonData>) {
        val directory = fsDirectory()
        val config = indexWriterConfig()
        IndexWriter(directory, config).use {
            dataList.map { data -> data.toDocument() }
                .let { docs -> it.addDocuments(docs) }
        }
    }

    fun search(find: String, count: Int): List<PersonData> {
        val directory = fsDirectory()
        DirectoryReader.open(directory).use {
            val indexSearcher = IndexSearcher(it)
            val nameQuery = TermQuery(Term("name", find))
            val result = indexSearcher.search(nameQuery, count)

            return result.scoreDocs
                .map { scoreDoc -> indexSearcher.doc(scoreDoc.doc) }
                .map { doc -> PersonData(doc) }
        }
    }

    private fun indexWriterConfig() = IndexWriterConfig(StandardAnalyzer())

    private fun fsDirectory(): FSDirectory? =
        FSDirectory.open(File(path).toPath())

}