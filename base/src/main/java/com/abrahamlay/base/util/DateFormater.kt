package com.abrahamlay.base.util

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

open class DateFormater {
    companion object {
        @JvmStatic
        @SuppressLint("SimpleDateFormat")
        fun changeDateFormat(
            dateInput: String?
        ): String {

            try {
                dateInput.let {
                    val inputFormat = SimpleDateFormat("yyyy-MM-dd")
                    val outputFormat = SimpleDateFormat(
                        "EEEE,  MMM dd, yyyy", Locale.ENGLISH
                    )
                    val date: Date
                    date = inputFormat.parse(dateInput!!)!!

                    return outputFormat.format(date)
                }
            } catch (e: ParseException) {
                e.printStackTrace()
            }

            return ""
        }
    }

}
