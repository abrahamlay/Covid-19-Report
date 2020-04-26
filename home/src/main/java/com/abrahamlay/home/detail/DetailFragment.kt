package com.abrahamlay.home.detail

import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abrahamlay.base.presentation.BaseActivity
import com.abrahamlay.base.presentation.BaseFragment
import com.abrahamlay.base.subscriber.BaseViewModel
import com.abrahamlay.domain.entities.Country
import com.abrahamlay.home.R
import com.abrahamlay.home.databinding.FragmentDetailBinding
import kotlinx.android.synthetic.main.fragment_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * Created by Abraham Lay on 2019-12-31.
 */
class DetailFragment : BaseFragment<BaseViewModel>() {

    private var country: Country? = null

    override val viewModel by viewModel<BaseViewModel>()

    companion object {
        const val PARAM_DETAIL_COUNTRY = "detailCountry"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            country = arguments?.getParcelable(PARAM_DETAIL_COUNTRY)
        }
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // create ContextThemeWrapper from the original Activity Context with the custom theme
        val contextThemeWrapper = ContextThemeWrapper(activity, R.style.AppTheme_NoActionBar)

        // clone the inflater using the ContextThemeWrapper
        val localInflater = inflater.cloneInContext(contextThemeWrapper)

        val binding = FragmentDetailBinding.inflate(localInflater, container, false)
        binding.globalView.countryData = country
        binding.countryData = country
        binding.lifecycleOwner = this

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
    }

    private fun initToolbar() {
        (activity as BaseActivity<*>).setSupportActionBar(toolbar)
        (activity as BaseActivity<*>).supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}