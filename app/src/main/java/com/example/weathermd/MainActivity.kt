package com.example.weathermd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weathermd.view.adapters.MainDailyListAdapter
import com.example.weathermd.view.adapters.MainHourlyListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //dasmdknaksldna
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initViews()

        main_hourly_list.apply {
            adapter = MainHourlyListAdapter()
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)

        }

        main_daily_list.adapter = MainDailyListAdapter()
        main_daily_list.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        main_daily_list.setHasFixedSize(true)
    }

    private fun initViews() {
        main_city_name_tv.text = "Moskow"
        main_data_tv.text = "8 Jule"
        main_weather_condition_icon.setImageResource(R.drawable.outline_wb_sunny_24)
        main_temp.text = "25\u00B0"
        main_temp_min_tv.text = "19\u00b0"
        main_temp_max_tv.text = "25\u00b0"
        main_temp_sr_tv.text = "22\u00b0"
        main_weather_image.setImageResource(R.mipmap.cloud)
        main_pressure_mu_tv.text = "1023hPa"
        main_humidity_mu_tv.text = "80%"
        main_wind_speed_mu_tv.text = "5 m/s"
        main_sunrise_mu_tv.text = "4:20"
        main_sunset_mu_tv.text = "21:30"

    }


}