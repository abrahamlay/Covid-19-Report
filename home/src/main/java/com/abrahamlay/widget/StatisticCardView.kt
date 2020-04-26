package com.abrahamlay.widget

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.databinding.BindingAdapter
import com.abrahamlay.home.R
import kotlinx.android.synthetic.main.view_statistic_card.view.*

/**
 * Created by Abraham Lay on 25/04/20.
 */
class StatisticCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private var statisticBackground: Drawable?
    private var statisticLabel: String?
    private var statisticValue: String?

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.StatisticCardView)
        this.statisticLabel = a.getString(R.styleable.StatisticCardView_scv_label)
        this.statisticValue = a.getString(R.styleable.StatisticCardView_scv_value)
        this.statisticBackground = a.getDrawable(R.styleable.StatisticCardView_scv_background)
        a.recycle()
        LayoutInflater.from(context).inflate(R.layout.view_statistic_card, this)

        tvStatisticLabel.text = statisticLabel
        tvStatisticValue.text = statisticValue
        clStatisticCard.background = statisticBackground

    }

    fun setValue(value: String?) {
        value?.let { tvStatisticValue.text = value }
    }


    fun setLabel(value: String) {
        tvStatisticLabel.text = value
    }

    fun setCardBackground(drawable: Drawable?) {
        clStatisticCard.background = drawable
    }
}