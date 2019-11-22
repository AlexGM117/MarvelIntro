package com.example.fintonictest.domain.client

import com.example.fintonictest.domain.client.model.response.ListResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("bvyob")
    fun getArchiveHeroes() : Deferred<Response<ListResponse>>
}