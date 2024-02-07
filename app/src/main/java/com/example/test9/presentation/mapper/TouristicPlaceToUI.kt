package com.example.test9.presentation.mapper

import com.example.test9.domain.model.TouristicPlace
import com.example.test9.presentation.model.TouristicPlaceUI

fun TouristicPlace.toUI():TouristicPlaceUI{
    return TouristicPlaceUI(
        id = id,
        cover = cover,
        price = price,
        title = title,
        location = location,
        reactionCount = reactionCount,
        rate = rate
    )
}