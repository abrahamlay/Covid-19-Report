package com.abrahamlay.data.dtos


import com.google.gson.annotations.SerializedName

data class SummaryDto(
    @SerializedName("Countries")
    val countries: List<Country>,
    @SerializedName("Date")
    val date: String,
    @SerializedName("Global")
    val global: Global
)