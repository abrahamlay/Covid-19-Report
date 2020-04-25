package com.abrahamlay.covid19app

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import com.abrahamlay.base.presentation.BaseActivity
import com.abrahamlay.covid19app.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<HomeViewModel>() {
    override val viewModel by viewModel<HomeViewModel>()
    override val resourceLayout: Int?
        get() {
            val viewbinding = ActivityMainBinding.inflate(this.layoutInflater)
            return viewbinding.root.sourceLayoutResId
        }

    override fun onInitObservers() {
        super.onInitObservers()
        viewModel.movieData.observe(this, Observer {
            Log.d("okhttp",it.global.toString())
        })
    }
}
