package com.example.fintonictest

import retrofit2.Response
import java.io.IOException
import java.lang.Exception

open class BaseRepository {
    suspend fun <T : Any> safeApiCall(call: suspend() -> Response<T>, errorMessage: String): T? {
        val result : Result<T> = safeApiResult(call, errorMessage)
        return when (result) {
            is Result.Success -> {
                result.data
            }

            is Result.Error -> null
        }
    }

    private suspend fun <T: Any> safeApiResult(call: suspend() -> Response<T>, errorMessage: String) : Result<T> {
        try {
            val response = call.invoke()
            if (response.isSuccessful && response.body() != null) {
                return Result.Success(response.body()!!)
            }
        } catch (e: Exception) {
            return Result.Error(e)
        }

        return Result.Error(IOException("Error Occurred during getting safe Api result, Custom ERROR - $errorMessage"))
    }
}