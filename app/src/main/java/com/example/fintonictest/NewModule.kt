package com.example.fintonictest

import com.example.fintonictest.characters.MainContract
import com.example.fintonictest.characters.MainPresenter
import com.example.fintonictest.domain.client.ApiService
import com.example.fintonictest.domain.manager.ApiRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NewModule {

    @Provides
    @Singleton
    fun provideRepository(apiService: ApiService) : ApiRepository {
        return ApiRepository(apiService)
    }

    @Provides
    @Singleton
    fun provideMainPresenter(repository: ApiRepository) : MainContract.Presenter {
        return MainPresenter(repository)
    }
}