package com.abrahamlay.data.repoimplementations

import com.abrahamlay.base.util.DateFormater
import com.abrahamlay.base.util.NumberFormater
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
                        DateFormater.changeDateTimeFormat(country.date),
                        NumberFormater.usFormat(country.newConfirmed),
                        NumberFormater.usFormat(country.newDeaths),
                        NumberFormater.usFormat(country.newRecovered),
                        country.slug,
                        NumberFormater.usFormat(country.totalConfirmed),
                        NumberFormater.usFormat(country.totalDeaths),
                        NumberFormater.usFormat(country.totalRecovered)
                    )

                },
                DateFormater.changeDateTimeFormat(summary.date),
                Global(
                    NumberFormater.usFormat(summary.global.newConfirmed),
                    NumberFormater.usFormat(summary.global.newDeaths),
                    NumberFormater.usFormat(summary.global.newRecovered),
                    NumberFormater.usFormat(summary.global.totalConfirmed),
                    NumberFormater.usFormat(summary.global.totalDeaths),
                    NumberFormater.usFormat(summary.global.totalRecovered)
                )
            )
        }
    }

}