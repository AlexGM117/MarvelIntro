package com.example.fintonictest

class ApiRepository : BaseRepository() {

    suspend fun makeRequest() : ListResponse? {
        return safeApiCall(
            call = {ApiClient.getInstance().getArchiveHeroes().await()},
            errorMessage = "Por el momento el servicio no esta disponible."
            )
    }
}