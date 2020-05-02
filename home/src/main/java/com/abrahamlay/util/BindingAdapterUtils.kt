package com.abrahamlay.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.abrahamlay.base.constant.Constants
import com.abrahamlay.base.util.GlideHelper
import com.abrahamlay.widget.StatisticCardView

/**
 * Created by Abraham Lay on 26/04/20.
 */
class BindingAdapterUtils {
    companion object {
        @JvmStatic
        @BindingAdapter("loadIcon")
        fun loadIcon(view: ImageView, countryCode: String?) {
            if (!countryCode.isNullOrEmpty()) {
                val addedUrl = String.format(Constants.THUMBNAIL_BASE_URL_EXTRA_LARGE, countryCode)
                GlideHelper.showImage(
                    addedUrl,
                    view,
                    view.context
                )
            }
        }


        @JvmStatic
        @BindingAdapter("scv_value")
        fun setValueBinding(view: StatisticCardView, value: String?) {
            view.setValue(value)
        }
    }
}