package com.abrahamlay.domain.repositories

import com.abrahamlay.domain.entities.SummaryData
import io.reactivex.Flowable

/**
 * Created by Abraham Lay on 2019-09-29.
 */

interface Covid19Repository {
    fun getSummary(): Flowable<SummaryData>
}