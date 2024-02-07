package com.example.test9.domain.usecase

import com.example.test9.data.common.ResultWrapper
import com.example.test9.domain.model.TouristicPlace
import com.example.test9.domain.repository.TouristicPlacesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTouristicPlacesUseCase @Inject constructor(
    private val touristicPlacesRepository: TouristicPlacesRepository
) {

    operator fun invoke(): Flow<ResultWrapper<List<TouristicPlace>>> = touristicPlacesRepository.getTouristicPlacesList()

}