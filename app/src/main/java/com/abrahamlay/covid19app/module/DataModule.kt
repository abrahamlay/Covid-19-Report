package com.abrahamlay.covid19app.module

import com.abrahamlay.data.repoimplementations.Covid19RepositoryImpl
import com.abrahamlay.domain.repositories.Covid19Repository
import org.koin.dsl.module

/**
 * Created by Abraham Lay on 2019-10-06.
 */

val dataModule = module {
    single<Covid19Repository> { Covid19RepositoryImpl(get()) }
}