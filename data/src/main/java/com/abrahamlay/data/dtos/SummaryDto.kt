package com.abrahamlay.data.dtos


import com.google.gson.annotations.SerializedName

data class SummaryDto(
    @SerializedName("Countries")
    val countries: List<CountryDto>,
    @SerializedName("Date")
    val date: String,
    @SerializedName("Global")
    val global: GlobalDto
)