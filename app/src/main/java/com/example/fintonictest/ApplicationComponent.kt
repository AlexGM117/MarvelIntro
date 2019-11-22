package com.example.fintonictest

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidModule::class,
    ApplicationModule::class,
    ClientModule::class,
    NewModule::class])
interface ApplicationComponent {
    fun inject(activity: MainActivity)
}