package com.abrahamlay.covid19app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.abrahamlay.base.subscriber.BaseViewModel
import com.abrahamlay.base.subscriber.DefaultSubscriber
import com.abrahamlay.domain.entities.SummaryData
import com.abrahamlay.domain.interactors.GetSummary

/**
 * Created by Abraham Lay on 25/04/20.
 */
class HomeViewModel(repositoryImpl: GetSummary) : BaseViewModel() {
    private val mutableRepo = MutableLiveData<SummaryData>()
    private val triggerFetch = MutableLiveData<Boolean>()
    val movieData: LiveData<SummaryData> = Transformations.switchMap(triggerFetch) {
        fetchMovie(repositoryImpl)
        return@switchMap mutableRepo
    }

    init {
        refreshMovie()
    }

    private fun fetchMovie(repositoryImpl: GetSummary) {
        repositoryImpl.execute(object : DefaultSubscriber<SummaryData>() {
            override fun onSuccess(data: SummaryData) {
                mutableRepo.postValue(data)
            }

        }, null)
    }

    fun refreshMovie() {
        triggerFetch.value = true
    }
}