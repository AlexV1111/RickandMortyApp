package com.example.rickandmortyapp.data.remote

import com.example.rickandmortyapp.data.dto.PersonDTO
import com.example.rickandmortyapp.data.dto.PersonListDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("character/")
    suspend fun getPersonList(@Query("page") page: Int): PersonListDTO

    @GET("character/{id}")
    suspend fun getPersonById(@Path("id") id: Int): PersonDTO
}