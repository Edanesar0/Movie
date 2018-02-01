package com.prueba.movies.app.network

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * interface que contiene las peticiones hacia el
 * servidor el cual retorna
 * el datos puro o una clase POJO GSON
 */
interface MoviesNetwork {

    @GET("movie/popular")
    fun sendPopular(@Query("api_key") api_key: String, @Query("language") language: String
                    , @Query("page") page: String): Observable<String>

    @GET("movie/top_rated")
    fun sendTop(@Query("api_key") api_key: String, @Query("language") language: String,
                @Query("page") page: String): Observable<String>

    @GET("search/movie")
    fun searchMovie(@Query("api_key") api_key: String, @Query("language") language: String,
                    @Query("query") query: String, @Query("page") page: String,
                    @Query("include_adult") include_adult: String): Observable<String>
}












