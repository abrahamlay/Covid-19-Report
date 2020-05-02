package com.abrahamlay.domain.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class CountryData(
    val country: String?,
    @PrimaryKey(autoGenerate = false) val countryCode: String,
    val date: String?,
    val newConfirmed: String?,
    val newDeaths: String?,
    val newRecovered: String?,
    val slug: String?,
    val totalConfirmed: String?,
    val totalDeaths: String?,
    val totalRecovered: String?
) : Parcelable