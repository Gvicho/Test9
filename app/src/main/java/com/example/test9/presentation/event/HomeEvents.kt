package com.example.test9.presentation.event

sealed class HomeEvents {
    data object ResetErrorMessageToNull:HomeEvents()
    data object LoadTouristicPlaces:HomeEvents()
}