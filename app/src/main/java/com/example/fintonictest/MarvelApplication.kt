package com.example.fintonictest

import android.app.Application

class MarvelApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        component = createComponent()
    }

    fun get() : MarvelApplication {
        return this
    }

    private fun createComponent(): ApplicationComponent {
        return DaggerApplicationComponent.builder()
            .androidModule(AndroidModule(this))
            .build()
    }

    fun getComponent() : ApplicationComponent {
        return component!!
    }

    companion object {
        var component: ApplicationComponent? = null
    }
}