package com.example.test9.data.model

import com.squareup.moshi.Json

data class TouristicPlaceDto(
    val id:Int,
    val cover:String,
    val price:String,
    val title:String,
    val location:String,
    @Json(name = "reaction_count")
    val reactionCount:Int,
    val rate:Int? = 0
) {
}