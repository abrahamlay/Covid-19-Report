package com.abrahamlay.data.datastore

import android.util.Log
import com.abrahamlay.data.apis.Covid19API
import com.abrahamlay.data.db.dao.SummaryDao
import com.abrahamlay.data.mapper.SummaryMapper
import com.abrahamlay.domain.entities.SummaryData
import io.reactivex.Flowable

/**
 * Created by Abraham Lay on 02/05/20.
 */
class SummaryDataStore constructor(
    private val dao: SummaryDao,
    private val api: Covid19API,
    private val mapper: SummaryMapper
) : DataStore<SummaryData> {

    override fun persist(data: SummaryData) = dao.replace(data)

    override fun findFromAPI(): Flowable<SummaryData> {
        return api.getSummary().map(mapper).doOnNext {
            Log.d("REPOSITORY API *** ", it.countries?.size.toString())
            persist(it)
        }
    }

    override fun findFromDb(): Flowable<SummaryData> {
        return dao.selectObjectAll().doOnNext {
            Log.d("REPOSITORY DB *** ", it.countries?.size.toString())
        }
    }
}