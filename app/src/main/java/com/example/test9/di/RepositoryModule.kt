package com.example.test9.di


import com.example.test9.data.common.HandleResponse
import com.example.test9.data.repository.TouristicPlacesRepositoryImpl
import com.example.test9.data.servise.TouristicPlacesService
import com.example.test9.domain.repository.TouristicPlacesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideWorkersRepository(
        touristicPlacesService: TouristicPlacesService,
        handleResponse: HandleResponse
    ): TouristicPlacesRepository {
        return TouristicPlacesRepositoryImpl(
            touristicPlacesService = touristicPlacesService,
            handleResponse = handleResponse
        )
    }

}