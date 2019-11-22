package com.example.fintonictest

import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AndroidModule(private val application: MarvelApplication) {

    @Provides
    @Singleton
    fun provideContext() : Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideResources() : Resources {
        return application.resources
    }
}