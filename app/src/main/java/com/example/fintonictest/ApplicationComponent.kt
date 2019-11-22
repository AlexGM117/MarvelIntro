package com.example.fintonictest

import com.example.fintonictest.activity.MainActivity
import com.example.fintonictest.domain.ClientModule
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