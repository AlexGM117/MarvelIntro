package com.example.fintonictest

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("bvyob")
    fun getArchiveHeroes() : Deferred<Response<ListResponse>>
}