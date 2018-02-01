package com.prueba.movies.entities

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Movie : RealmObject() {
    @PrimaryKey
    var id: Int = 0
    var overview: String? = null
    var original_language: String? = null
    var original_title: String? = null
    var video: Boolean? = null
    var title: String? = null
    var poster_path: String? = null
    var backdrop_path: String? = null
    var release_date: String? = null
    var vote_average: Int? = null
    var popularity: Double? = null
    var adult: Boolean? = null
    var vote_count: Int? = null
}
