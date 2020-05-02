package com.abrahamlay.data.mapper

import com.abrahamlay.base.util.DateFormater
import com.abrahamlay.data.dtos.SummaryDto
import com.abrahamlay.domain.entities.SummaryData

/**
 * Created by Abraham Lay on 28/04/20.
 */

class SummaryMapper :
    BaseMapper<SummaryDto, SummaryData>() {
    override fun apply(from: SummaryDto): SummaryData? {
        return SummaryData(
            from.countries.let { CountryMapper().apply(it)?.toList() },
            DateFormater.changeDateTimeFormat(from.date),
            from.global.let { GlobalMapper().apply(it) })
    }
}