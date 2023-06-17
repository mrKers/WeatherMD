package com.example.weathermd.view.adapters

import android.nfc.Tag
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weathermd.R

const val TAG = "RV_TEST"

class MainHourlyListAdapter : RecyclerView.Adapter<MainHourlyListAdapter.HourlyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyViewHolder {

        Log.d(TAG, "-----onCreateViewHolder: ")
        
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_main_hourly, parent, false)
        return HourlyViewHolder(view)
    }

    override fun getItemCount() = 30

    override fun onBindViewHolder(holder: HourlyViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: ")
    }

    inner class HourlyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            Log.d(TAG, "HourlyViewHolder: ")
        }


    }
}