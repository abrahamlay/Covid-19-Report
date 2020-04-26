package com.abrahamlay.domain.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Country(
    val country: String?,
    val countryCode: String?,
    val date: String?,
    val newConfirmed: String?,
    val newDeaths: String?,
    val newRecovered: String?,
    val slug: String?,
    val totalConfirmed: String?,
    val totalDeaths: String?,
    val totalRecovered: String?
) : Parcelable