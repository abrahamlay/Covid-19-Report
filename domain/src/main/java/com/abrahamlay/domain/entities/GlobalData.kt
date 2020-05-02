package com.abrahamlay.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GlobalData(
    val newConfirmed: String?,
    val newDeaths: String?,
    val newRecovered: String?,
    val totalConfirmed: String?,
    val totalDeaths: String?,
    val totalRecovered: String?,
    @PrimaryKey(autoGenerate = false) val id: Int = 0
)