package com.example.test9.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test9.data.common.ResultWrapper
import com.example.test9.domain.usecase.GetTouristicPlacesUseCase
import com.example.test9.presentation.event.HomeEvents
import com.example.test9.presentation.mapper.toUI
import com.example.test9.presentation.state.HomePageState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel@Inject constructor(
    private val getTouristicPlacesUseCase: GetTouristicPlacesUseCase
) :ViewModel() {

    private val _uiStateFlow = MutableStateFlow(HomePageState())
    val uiStateFlow : StateFlow<HomePageState> = _uiStateFlow


    fun onEvent(event:HomeEvents){
        when(event){
            HomeEvents.LoadTouristicPlaces -> loadTouristicPlaces()
            HomeEvents.ResetErrorMessageToNull -> resetErrorMessageToNull()
        }
    }

    private fun loadTouristicPlaces(){
        viewModelScope.launch {
            getTouristicPlacesUseCase().collect{result->
                when(result){
                    is ResultWrapper.Error -> {
                        _uiStateFlow.update {
                            it.copy(errorMessage = result.errorMessage)
                        }
                    }
                    is ResultWrapper.Loading -> {
                        _uiStateFlow.update {
                            it.copy(isLoading = result.loading)
                        }
                    }
                    is ResultWrapper.Success -> {

                        val resultData = withContext(Dispatchers.Default){
                            result.data!!.map {
                                it.toUI()
                            }
                        }

                        _uiStateFlow.update {
                            it.copy(isSuccess = resultData)
                        }
                    }
                }
            }
        }
    }

    private fun resetErrorMessageToNull(){
        _uiStateFlow.update {
            it.copy(errorMessage = null)
        }
    }
}