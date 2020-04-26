package com.abrahamlay.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.abrahamlay.base.subscriber.BaseViewModel
import com.abrahamlay.base.subscriber.DefaultSubscriber
import com.abrahamlay.base.subscriber.ResultState
import com.abrahamlay.domain.entities.SummaryData
import com.abrahamlay.domain.interactors.GetSummary

/**
 * Created by Abraham Lay on 25/04/20.
 */
class HomeViewModel(repositoryImpl: GetSummary) : BaseViewModel() {
    private val mutableRepo = MutableLiveData<ResultState<SummaryData>>()
    private val triggerFetch = MutableLiveData<Boolean>()
    val liveData: LiveData<ResultState<SummaryData>> = Transformations.switchMap(triggerFetch) {
        fetchSummary(repositoryImpl)
        return@switchMap mutableRepo
    }

    init {
        refreshData()
    }

    private fun fetchSummary(repositoryImpl: GetSummary) {
        repositoryImpl.execute(object : DefaultSubscriber<SummaryData>() {
            override fun onSuccess(data: ResultState<SummaryData>) {
                mutableRepo.postValue(data)
            }

            override fun onError(error: ResultState<SummaryData>) {
                mutableRepo.postValue(error)
            }
        }, null)
    }

    fun refreshData() {
        triggerFetch.value = true
    }
}