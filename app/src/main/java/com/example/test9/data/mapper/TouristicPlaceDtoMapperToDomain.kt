package com.example.test9.data.mapper

import com.example.test9.data.model.TouristicPlaceDto
import com.example.test9.domain.model.TouristicPlace

fun TouristicPlaceDto.toDomain(): TouristicPlace {
    return TouristicPlace(
        id = id,
        cover = cover,
        price = price,
        title = title,
        location = location,
        reactionCount = reactionCount,
        rate = rate?:0
    )
}