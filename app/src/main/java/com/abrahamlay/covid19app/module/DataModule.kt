package com.abrahamlay.covid19app.module

import androidx.room.Room
import com.abrahamlay.covid19app.BuildConfig
import com.abrahamlay.data.datastore.SummaryDataStore
import com.abrahamlay.data.db.AppDatabase
import com.abrahamlay.data.db.dao.SummaryDao
import com.abrahamlay.data.mapper.SummaryMapper
import com.abrahamlay.data.repoimplementations.Covid19RepositoryImpl
import com.abrahamlay.domain.repositories.Covid19Repository
import org.koin.dsl.module

/**
 * Created by Abraham Lay on 2019-10-06.
 */

val dataModule = module {
    single<AppDatabase> {
        Room.databaseBuilder(get(), AppDatabase::class.java, BuildConfig.APPLICATION_ID)
            .build()
    }
    single<SummaryMapper> { SummaryMapper() }
    single<SummaryDao> {
        val database: AppDatabase = get()
        return@single database.summaryDao()
    }
    single<SummaryDataStore> { SummaryDataStore(get(), get(), get()) }
    single<Covid19Repository> { Covid19RepositoryImpl(get()) }
}