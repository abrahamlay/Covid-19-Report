package com.abrahamlay.covid19app.module


import com.abrahamlay.covid19app.HomeViewModel
import org.koin.androidx.experimental.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Abraham Lay on 2019-10-06.
 */

val viewModelModule = module {
    viewModel<HomeViewModel>()
//    viewModel<TopRatedMovieViewModel>()
}