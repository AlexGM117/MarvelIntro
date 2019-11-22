package com.example.fintonictest.domain.manager

import com.example.fintonictest.domain.client.ApiService
import com.example.fintonictest.domain.client.model.response.ListResponse

class ApiRepository(var service: ApiService) : BaseRepository() {

    suspend fun makeRequest() : ListResponse? {
        return safeApiCall(
            call = {service.getArchiveHeroes().await()},
            errorMessage = "Por el momento el servicio no esta disponible.")
    }
}