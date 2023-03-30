package com.apa.accenture.androidprueba.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/api/10231204575760255/search/{name}")
    suspend fun getSuperheroes(@Path("name") superheroName:String):Response<SuperheroDataResponse>

    @GET("/api/10231204575760255/{id}")
    suspend fun getSuperheroesDetail(@Path("id") superheroId:String):Response<SuperheroDetailResponse>
}