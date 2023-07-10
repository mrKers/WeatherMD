package com.example.weathermd


import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.pm.PackageManager
import android.location.Location
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weathermd.bisiness.model.DailyWeatherModel
import com.example.weathermd.bisiness.model.HourlyWeatherModel
import com.example.weathermd.bisiness.model.WeatherData
import com.example.weathermd.presenters.MainPresenter
import com.example.weathermd.view.MainView
import com.example.weathermd.view.adapters.MainDailyListAdapter
import com.example.weathermd.view.adapters.MainHourlyListAdapter
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import moxy.MvpActivity
import moxy.ktx.moxyPresenter



const val TAG = "GEO TEST"

class MainActivity : MvpActivity(), MainView {


    private val mainPresenter by moxyPresenter { MainPresenter() }

    private val geoService by lazy { LocationServices.getFusedLocationProviderClient(this) }
    private val locationRequest by lazy { initLocationRequest() }
    private lateinit var mLocation: Location

   @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       initViews()

        main_hourly_list.apply {
            adapter = MainHourlyListAdapter()
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)

        }
        main_hourly_list.apply {
            adapter = MainDailyListAdapter()
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            main_daily_list.setHasFixedSize(true)
        }


       mainPresenter.enable()

        geoService.requestLocationUpdates(locationRequest, geoCallback, null)
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

    //------------moxy code--------------
    override fun displayLocation(data: String) {
        main_city_name_tv.text = data
    }

    override fun displayCurrentData(data: WeatherData) {

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

    override fun displayHourlyData(data: List<HourlyWeatherModel>) {
        (main_hourly_list.adapter as MainHourlyListAdapter).updateData(data)

    }

    override fun displayDailyData(data: List<DailyWeatherModel>) {
        (main_daily_list.adapter as MainDailyListAdapter).updateData(data)
    }

    override fun displayError(error: Throwable) {

    }

    override fun setLoading(flag: Boolean) {

    }
    //------------moxy code--------------

    // ---------location code ---------------
    fun initLocationRequest(): LocationRequest {
        val request = LocationRequest.create()
        return request.apply {
            interval = 10000
            fastestInterval = 5000
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY

        }
    }

    private val geoCallback = object : LocationCallback() {
        override fun onLocationResult(geo: LocationResult) {
            Log.d(TAG,"onLocationResult: ${geo.locations.size}")
            for (location in geo.locations) {
                mLocation = location

                mainPresenter.refresh(mLocation.latitude.toString(),mLocation.longitude.toString())

                Log.d(TAG, "onLocationResult: lat: ${location.latitude} ; lon: ${location.longitude}")
            }

        }
    }



}