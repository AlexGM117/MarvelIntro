package com.example.fintonictest

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