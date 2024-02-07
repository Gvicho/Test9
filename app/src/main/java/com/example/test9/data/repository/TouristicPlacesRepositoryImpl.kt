package com.example.test9.data.repository

import com.example.test9.data.common.HandleResponse
import com.example.test9.data.common.ResultWrapper
import com.example.test9.data.common.mapResultWrapper
import com.example.test9.data.mapper.toDomain
import com.example.test9.data.servise.TouristicPlacesService
import com.example.test9.domain.model.TouristicPlace
import com.example.test9.domain.repository.TouristicPlacesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TouristicPlacesRepositoryImpl @Inject constructor(
    private val touristicPlacesService: TouristicPlacesService,
    private val handleResponse: HandleResponse
) :TouristicPlacesRepository{

    override fun getTouristicPlacesList(): Flow<ResultWrapper<List<TouristicPlace>>> {
        return handleResponse.safeApiCall {
            touristicPlacesService.getTouristicPlacesList()
        }.mapResultWrapper {
            it.map {touristicPlaceDto ->
                touristicPlaceDto.toDomain()
            }
        }
    }
}