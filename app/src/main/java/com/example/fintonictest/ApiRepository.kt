package com.example.fintonictest

class ApiRepository(var service: ApiService) : BaseRepository() {

    suspend fun makeRequest() : ListResponse? {
        return safeApiCall(
            call = {service.getArchiveHeroes().await()},
            errorMessage = "Por el momento el servicio no esta disponible.")
    }
}