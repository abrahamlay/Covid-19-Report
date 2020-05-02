package com.abrahamlay.data.repoimplementations

import com.abrahamlay.data.datastore.SummaryDataStore
import com.abrahamlay.domain.entities.SummaryData
import com.abrahamlay.domain.repositories.Covid19Repository
import io.reactivex.Flowable

/**
 * Created by Abraham Lay on 2019-09-29.
 */


class Covid19RepositoryImpl constructor(
    private val summaryDataStore: SummaryDataStore
) :
    Covid19Repository {
    override fun getSummary(): Flowable<SummaryData> {
        return summaryDataStore.findAll()
    }
}