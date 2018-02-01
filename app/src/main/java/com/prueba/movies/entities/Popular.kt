package com.prueba.movies.entities

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Popular : RealmObject() {
    @PrimaryKey
    var page: Int = 0
    var totalPages: Int = 0
    var results: RealmList<Movie?>? = null
    var totalResults: Int = 0
}
