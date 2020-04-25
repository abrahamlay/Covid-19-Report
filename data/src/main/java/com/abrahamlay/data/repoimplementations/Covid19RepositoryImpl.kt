package com.abrahamlay.data.repoimplementations

import com.abrahamlay.data.apis.Covid19API
import com.abrahamlay.domain.entities.Country
import com.abrahamlay.domain.entities.Global
import com.abrahamlay.domain.entities.SummaryData
import com.abrahamlay.domain.repositories.Covid19Repository
import io.reactivex.Flowable

/**
 * Created by Abraham Lay on 2019-09-29.
 */


class Covid19RepositoryImpl constructor(private val api: Covid19API) : Covid19Repository {
    override fun getSummary(): Flowable<SummaryData> {
        return api.getSummary().map { summary ->
            SummaryData(
                summary.countries.map { country ->
                    Country(
                        country.country,
                        country.countryCode,
                        country.date,
                        country.newConfirmed,
                        country.newDeaths,
                        country.newRecovered,
                        country.slug,
                        country.totalConfirmed,
                        country.totalDeaths,
                        country.totalRecovered
                    )

                },
                summary.date,
                Global(
                    summary.global.newConfirmed,
                    summary.global.newDeaths,
                    summary.global.newRecovered,
                    summary.global.totalConfirmed,
                    summary.global.totalDeaths,
                    summary.global.totalRecovered
                )
            )
        }
    }

}