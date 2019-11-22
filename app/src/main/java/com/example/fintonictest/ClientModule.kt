package com.example.fintonictest

import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class ClientModule {

    @Provides
    @Singleton
    fun provideApiManager(retrofit: Retrofit) : ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(@Named("url") baseUrl: String, converterFactory: Converter.Factory, adapterFactory: CallAdapter.Factory, okHttpCliente: OkHttpClient) : Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(adapterFactory)
            .client(okHttpCliente)
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClinet(@Named("networkTimeoutInSeconds") timeOutTime: Int, loggingInterceptor: HttpLoggingInterceptor) : OkHttpClient{
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(timeOutTime.toLong(), TimeUnit.SECONDS)
            .readTimeout(timeOutTime.toLong(), TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)

        return okHttpClient.build()
    }

    @Provides
    @Singleton
    fun provideLoginInterceptor() : HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideGsonConverterFactory(gson: Gson) : Converter.Factory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    @Singleton
    fun provideCoroutinesAdapterFactory() : CoroutineCallAdapterFactory {
        return CoroutineCallAdapterFactory()
    }

    @Provides
    @Singleton
    fun provideGson() : Gson {
        return Gson()
    }
}