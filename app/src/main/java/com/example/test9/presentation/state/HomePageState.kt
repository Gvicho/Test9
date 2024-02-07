package com.example.test9.presentation.state

import com.example.test9.presentation.model.TouristicPlaceUI

data class HomePageState(
    val isLoading:Boolean = false,
    val isSuccess:List<TouristicPlaceUI>? = null,
    val errorMessage:String? = null
) {
}