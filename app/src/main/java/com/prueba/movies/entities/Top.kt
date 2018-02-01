package com.prueba.movies.entities

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Top : RealmObject() {
    @PrimaryKey
    var page: Int? = null
    var totalPages: Int? = null
    var results: RealmList<Movie?>? = null
    var totalResults: Int? = null
}
