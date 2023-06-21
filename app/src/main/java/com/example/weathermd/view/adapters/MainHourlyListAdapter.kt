package com.example.weathermd.view.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.weathermd.R
import com.example.weathermd.bisiness.model.HourlyWeatherModel
import com.example.weathermd.databinding.ItemMainDailyBinding
import com.example.weathermd.databinding.ItemMainHourlyBinding
import com.google.android.material.textview.MaterialTextView


class MainHourlyListAdapter : BaseAdapter<HourlyWeatherModel>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyViewHolder {

        val binding =
            ItemMainHourlyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HourlyViewHolder(binding)
    }


    @SuppressLint("NonConstantResourceId")
    inner class HourlyViewHolder(private val binding: ItemMainHourlyBinding) :
        BaseViewHolder(binding.root) {

        override fun bindView(position: Int) {
            binding.itemHourlyPopTv.text = "жопа"
            binding.itemHourlyTempTv.text = "tits"
            binding.itemHourlyTimeTv.text = "dicks"
            binding.itemHourlyWeatherConditionIcon.setImageResource(R.drawable.outline_wb_sunny_24)

        }


    }
}