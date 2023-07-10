package com.example.weathermd.view

import com.example.weathermd.bisiness.model.DailyWeatherModel
import com.example.weathermd.bisiness.model.HourlyWeatherModel
import com.example.weathermd.bisiness.model.WeatherData
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import java.lang.Error

interface MainView : MvpView {

    @AddToEndSingle
    fun displayLocation(data: String)

    @AddToEndSingle
    fun displayCurrentData(data: WeatherData)

    @AddToEndSingle
    fun displayHourlyData(data: List<HourlyWeatherModel>)

    @AddToEndSingle
    fun displayDailyData(data: List<DailyWeatherModel>)

    @AddToEndSingle
    fun displayError(error: Throwable)

    @AddToEndSingle
    fun setLoading(flag:Boolean)
}