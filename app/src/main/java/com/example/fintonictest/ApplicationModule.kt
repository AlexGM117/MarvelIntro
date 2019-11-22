package com.example.fintonictest

import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApplicationModule {

    private val BASE_URL = "https://api.myjson.com/bins/"
    private val NETWORK_CONNECTION_TIMEOUT = 30

    @Provides
    @Named("url")
    fun provideBaseUrl(): String {
        return BASE_URL
    }

    @Provides
    @Singleton
    @Named("networkTimeoutInSeconds")
    fun provideNetworkTimeoutInSeconds(): Int {
        return NETWORK_CONNECTION_TIMEOUT
    }
}