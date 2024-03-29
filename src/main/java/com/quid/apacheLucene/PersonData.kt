package com.quid.apacheLucene

import org.apache.lucene.document.Field
import org.apache.lucene.document.StringField
import org.apache.lucene.document.TextField
import org.apache.lucene.index.IndexableField
import java.util.*

data class PersonData(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val city: String,
    val description: String
) {
    fun toDocument() = mutableListOf<IndexableField>().apply {
        add(TextField("id", id.toString(), Field.Store.YES))
        add(StringField("name", name, Field.Store.YES))
        add(StringField("city", city, Field.Store.YES))
        add(StringField("description", description, Field.Store.YES))
    }
}
