package com.example.test9.data.servise

import com.example.test9.data.model.TouristicPlaceDto
import retrofit2.Response
import retrofit2.http.GET

interface TouristicPlacesService {
    @GET("0545ddc1-c487-46ce-b70c-5b95270d6b76")
    suspend fun getTouristicPlacesList(): Response<List<TouristicPlaceDto>>
}