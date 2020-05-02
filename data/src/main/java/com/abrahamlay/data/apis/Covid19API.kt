package com.abrahamlay.data.apis

import com.abrahamlay.data.dtos.SummaryDto
import io.reactivex.Flowable
import retrofit2.http.GET

/**
 * Created by Abraham Lay on 2019-09-29.
 */
interface Covid19API {
    @GET("summary")
    fun getSummary(): Flowable<SummaryDto>
}