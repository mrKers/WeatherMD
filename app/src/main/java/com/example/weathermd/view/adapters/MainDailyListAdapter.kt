package com.example.weathermd.view.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.weathermd.R
import com.example.weathermd.bisiness.model.DailyWeatherModel
import com.google.android.material.textview.MaterialTextView

class MainDailyListAdapter : BaseAdapter<DailyWeatherModel>() {

    /*
    *
    * На этом месте будет обработчик нажатий
    *
     */


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main_daily, parent, false)
        return DailyViewHolder(view)
    }
        @SuppressLint("NonConstantResourceId")
         inner class DailyViewHolder(view: View) : BaseViewHolder(view) {

             @BindView(R.id.item_daily_date_tv)
             lateinit var date:MaterialTextView

             @BindView(R.id.item_daily_pop_tv)
             lateinit var popRate:MaterialTextView

             @BindView(R.id.item_daily_min_temp_tv)
             lateinit var minTemp:MaterialTextView

             @BindView(R.id.item_daily_max_temp_tv)
             lateinit var maxTemp:MaterialTextView

             @BindView(R.id.item_daily_weather_condition_icon)
             lateinit var icon:ImageView

             init {

                 ButterKnife.bind(this,itemView)

             }

        override fun bindView(position: Int) {
            date.text = "25 Saturday"
            popRate.text = "25%"
            maxTemp.text = "18"
            minTemp.text = "12"
            icon.setImageResource(R.drawable.outline_wb_sunny_24)

        }

    }

}