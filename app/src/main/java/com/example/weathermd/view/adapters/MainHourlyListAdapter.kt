package com.example.weathermd.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weathermd.R

class MainHourlyListAdapter : RecyclerView.Adapter <MainHourlyListAdapter.HourlyViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main_hourly,parent,false)
        return HourlyViewHolder(view)
    }

    override fun getItemCount()=8

    override fun onBindViewHolder(holder: HourlyViewHolder, position: Int) {

    }

    inner class HourlyViewHolder(view: View) : RecyclerView.ViewHolder (view) {


    }
}