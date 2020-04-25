package com.abrahamlay.covid19app.module

import com.abrahamlay.domain.AndroidUIThread
import com.abrahamlay.domain.PostExecutionThread
import com.abrahamlay.domain.interactors.GetSummary
import org.koin.dsl.module

/**
 * Created by Abraham Lay on 2019-10-06.
 */

val useCaseModule = module {
    single<PostExecutionThread> { return@single AndroidUIThread() }
    factory { GetSummary(get(), get()) }
//    factory { GetTopRatedMovies(get(), get()) }
}