package com.abrahamlay.data.mapper

import com.abrahamlay.base.util.DateFormater
import com.abrahamlay.base.util.NumberFormater
import com.abrahamlay.data.dtos.CountryDto
import com.abrahamlay.domain.entities.CountryData

/**
 * Created by Abraham Lay on 28/04/20.
 */
class CountryMapper : BaseMapper<CountryDto, CountryData>() {
    override fun apply(from: CountryDto): CountryData? {
        return CountryData(
            from.country,
            from.countryCode,
            DateFormater.changeDateTimeFormat(from.date),
            NumberFormater.usFormat(from.newConfirmed),
            NumberFormater.usFormat(from.newDeaths),
            NumberFormater.usFormat(from.newRecovered),
            from.slug,
            NumberFormater.usFormat(from.totalConfirmed),
            NumberFormater.usFormat(from.totalDeaths),
            NumberFormater.usFormat(from.totalRecovered)
        )
    }
}