package com.example.test9.domain.repository

import com.example.test9.data.common.ResultWrapper
import com.example.test9.domain.model.TouristicPlace
import kotlinx.coroutines.flow.Flow

interface TouristicPlacesRepository {

    fun getTouristicPlacesList(): Flow<ResultWrapper<List<TouristicPlace>>>

}