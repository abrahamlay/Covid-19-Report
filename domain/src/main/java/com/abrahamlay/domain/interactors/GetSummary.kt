package com.abrahamlay.domain.interactors

import com.abrahamlay.domain.PostExecutionThread
import com.abrahamlay.domain.UseCase
import com.abrahamlay.domain.entities.SummaryData
import com.abrahamlay.domain.repositories.Covid19Repository
import io.reactivex.Flowable

/**
 * Created by Abraham Lay on 25/04/20.
 */
class GetSummary constructor(
    private val repository: Covid19Repository,
    postExecutionThread: PostExecutionThread
) : UseCase<SummaryData, Void?>(postExecutionThread) {
    override fun build(params: Void?): Flowable<SummaryData> =
        repository.getSummary()
}