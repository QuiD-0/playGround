package com.quid.apacheLucene

import org.apache.lucene.document.Document
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
    constructor(id: Document?) : this(
        id = UUID.fromString(id?.get("id")),
        name = id?.get("name") ?: "",
        city = id?.get("city") ?: "",
        description = id?.get("description") ?: ""
    )

    fun toDocument() = mutableListOf<IndexableField>().apply {
        add(TextField("id", id.toString(), Field.Store.YES))
        add(StringField("name", name, Field.Store.YES))
        add(StringField("city", city, Field.Store.YES))
        add(StringField("description", description, Field.Store.YES))
    }
}
