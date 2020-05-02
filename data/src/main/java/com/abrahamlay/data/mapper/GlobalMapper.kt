package com.abrahamlay.data.mapper

import com.abrahamlay.base.util.NumberFormater
import com.abrahamlay.data.dtos.GlobalDto
import com.abrahamlay.domain.entities.GlobalData

/**
 * Created by Abraham Lay on 28/04/20.
 */
class GlobalMapper : BaseMapper<GlobalDto, GlobalData>() {
    override fun apply(from: GlobalDto): GlobalData? {
        return GlobalData(
            NumberFormater.usFormat(from.newConfirmed),
            NumberFormater.usFormat(from.newDeaths),
            NumberFormater.usFormat(from.newRecovered),
            NumberFormater.usFormat(from.totalConfirmed),
            NumberFormater.usFormat(from.totalDeaths),
            NumberFormater.usFormat(from.totalRecovered)
        )
    }
}