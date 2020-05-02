package com.abrahamlay.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abrahamlay.domain.entities.CountryData
import com.abrahamlay.home.databinding.ItemSummaryCountryBinding

/**
 * Created by Abraham Lay on 26/04/20.
 */
class CountryAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, pos: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val binding = ItemSummaryCountryBinding.bind(
            inflater.inflate(
                R.layout.item_summary_country,
                viewGroup,
                false
            )
        )
        return CountryItemViewHolder(binding)
    }

    var data: List<CountryData?>? = null

    var onClickListener: OnClickListener? = null

    override fun getItemCount(): Int {
        return data?.size!!
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, pos: Int) {
        (viewHolder as CountryItemViewHolder).itemSummaryCountryBinding.countryData = data!![pos]
        viewHolder.setOnClickListener(View.OnClickListener {
            onClickListener?.onItemClicked(
                data!![pos]!!
            )
        })
    }

    interface OnClickListener {
        fun onItemClicked(data: Any)
    }

    inner class CountryItemViewHolder(val itemSummaryCountryBinding: ItemSummaryCountryBinding) :
        RecyclerView.ViewHolder(itemSummaryCountryBinding.root) {

        fun setOnClickListener(listener: View.OnClickListener) {
            itemView.setOnClickListener(listener)
        }
    }


}