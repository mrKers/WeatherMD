package com.example.weathermd.view.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.weathermd.R
import com.example.weathermd.bisiness.model.DailyWeatherModel
import com.example.weathermd.databinding.ItemMainDailyBinding

class MainDailyListAdapter : BaseAdapter<DailyWeatherModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyViewHolder {
        val binding =
            ItemMainDailyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DailyViewHolder(binding)
    }


    inner class DailyViewHolder(private val binding: ItemMainDailyBinding) :
        BaseViewHolder(binding.root) {

        override fun bindView(position: Int) {
            binding.itemDailyDateTv.text = "хуй"
            binding.itemDailyPopTv.text = "пизда"
            binding.itemDailyMaxTempTv.text = "залупа"
            binding.itemDailyMinTempTv.text = "блять"
            binding.itemDailyWeatherConditionIcon.setImageResource(R.drawable.outline_wb_sunny_24)


        }

    }

}