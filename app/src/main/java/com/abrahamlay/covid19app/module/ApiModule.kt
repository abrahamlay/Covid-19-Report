package com.abrahamlay.covid19app.module

import com.abrahamlay.covid19app.WebApiProvider
import com.abrahamlay.data.apis.Covid19API
import org.koin.dsl.module

/**
 * Created by Abraham Lay on 2019-10-06.
 */

val apiModule = module {
    single { WebApiProvider }
    single {
        get<WebApiProvider>()
            .getRetrofit()
            .create(Covid19API::class.java)
    }
}