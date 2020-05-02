package com.abrahamlay.data.db

import androidx.room.TypeConverter
import com.abrahamlay.domain.entities.CountryData
import com.abrahamlay.domain.entities.GlobalData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


/**
 * Created by Abraham Lay on 27/04/20.
 */
class AppTypeConverters {

    @TypeConverter
    fun stringToGlobal(
        string: String
    ): GlobalData = Gson().fromJson(string, GlobalData::class.java)

    @TypeConverter
    fun globalDataToString(
        globalData: GlobalData
    ): String = Gson().toJson(globalData)

    @TypeConverter
    fun stringToCountry(
        string: String
    ): CountryData = Gson().fromJson(string, CountryData::class.java)

    @TypeConverter
    fun countryDataToString(
        countryData: CountryData
    ): String = Gson().toJson(countryData)

    @TypeConverter
    fun listCountryToString(
        string: String
    ): List<CountryData?>? {
        val listType: Type = object : TypeToken<List<CountryData?>?>() {}.type;
        return Gson().fromJson(string, listType)
    }

    @TypeConverter
    fun listCountryDataToString(
        list: List<CountryData?>?
    ): String = Gson().toJson(list)

}