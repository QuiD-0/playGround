package com.quid.apacheLucene

data class PersonMaker(val count: Int) {
    fun make(): List<PersonData> {
        return IntRange(1, count).map {
            PersonData(
                name = "Person $it",
                city = "City $it",
                description = "Description $it"
            )
        }
    }
}