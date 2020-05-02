package com.abrahamlay.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.abrahamlay.data.db.dao.SummaryDao
import com.abrahamlay.domain.entities.CountryData
import com.abrahamlay.domain.entities.GlobalData
import com.abrahamlay.domain.entities.SummaryData

/**
 * Created by Abraham Lay on 27/04/20.
 */
@Database(
    entities = [SummaryData::class, GlobalData::class, CountryData::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(AppTypeConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun summaryDao(): SummaryDao
}
