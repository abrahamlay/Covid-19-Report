package com.abrahamlay.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.abrahamlay.base.presentation.BaseActivity
import com.abrahamlay.base.presentation.BaseFragment
import com.abrahamlay.base.subscriber.ResultState
import com.abrahamlay.domain.entities.Country
import com.abrahamlay.domain.entities.SummaryData
import com.abrahamlay.home.databinding.FragmentHomeBinding
import com.abrahamlay.home.detail.DetailFragment
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.view_statistic_section.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Abraham Lay on 25/04/20.
 */
class HomeFragment : BaseFragment<HomeViewModel>(), SwipeRefreshLayout.OnRefreshListener,
    CountryAdapter.OnClickListener {
    private lateinit var adapter: CountryAdapter
    override val viewModel by viewModel<HomeViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onInitObservers() {
        super.onInitObservers()
        adapter = CountryAdapter()
        adapter.onClickListener = this
        refresh.setOnRefreshListener(this)
        viewModel.liveData.observe(this, Observer {
            onResultLoaded(it)
        })
    }


    override fun onInitViews() {
        super.onInitViews()
        (activity as BaseActivity<*>).setSupportActionBar(toolbar)
        showLoading()
    }

    private fun onResultLoaded(resultState: ResultState<SummaryData>?) {
        when (resultState) {
            is ResultState.Success -> {
                hideLoading()
                showGlobalCases(resultState)
                showCountryList(resultState)
            }
            is ResultState.Error -> {
                hideLoading()
                Toast.makeText(context, resultState.throwable.message, Toast.LENGTH_SHORT).show()
            }
            is ResultState.Loading -> {
                showLoading()
            }
        }

    }

    private fun showGlobalCases(resultState: ResultState.Success<SummaryData>) {
        datePage.text = resultState.data.date
        scvNewConfirmed.setValue(resultState.data.global?.newConfirmed)
        scvNewDeath.setValue(resultState.data.global?.newDeaths)
        scvNewRecovered.setValue(resultState.data.global?.newRecovered)
        scvTotalConfirmed.setValue(resultState.data.global?.totalConfirmed)
        scvTotalDeath.setValue(resultState.data.global?.totalDeaths)
        scvTotalRecovered.setValue(resultState.data.global?.totalRecovered)
    }

    private fun showCountryList(resultState: ResultState.Success<SummaryData>) {
        (adapter as? CountryAdapter)?.data = resultState.data.countries
        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(context)
    }

    override fun onRefresh() {
        showLoading()
        viewModel.refreshData()
    }

    fun showLoading() {
        refresh.isRefreshing = true
    }

    fun hideLoading() {
        refresh.isRefreshing = false
    }

    override fun onItemClicked(data: Any) {
        Toast.makeText(context, (data as Country).country, Toast.LENGTH_SHORT).show()
        val bundle = bundleOf(Pair(DetailFragment.PARAM_DETAIL_COUNTRY, (data as Country)))
        findNavController().navigate(R.id.action_mainFragment_to_detailFragment, bundle)
    }

}