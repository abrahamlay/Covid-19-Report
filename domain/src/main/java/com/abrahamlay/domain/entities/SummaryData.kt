package com.abrahamlay.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SummaryData(
    val countries: List<CountryData?>?,
    val date: String,
    val global: GlobalData?,
    @PrimaryKey(autoGenerate = false) val id: Int = 0
)