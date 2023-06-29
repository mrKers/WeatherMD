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
import com.example.weathermd.view.adapters.MainDailyListAdapter
import com.example.weathermd.view.adapters.MainHourlyListAdapter
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*


const val GEO_LOCATION_REQUEST_COD_SUCCESS = 1
const val TAG = "GEO TEST"

class MainActivity : AppCompatActivity() {


    private val geoService by lazy { LocationServices.getFusedLocationProviderClient(this) }
    private val locationRequest by lazy { initLocationRequest() }
    private lateinit var mLocation: Location

   @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkPermission()

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
                Log.d(TAG, "onLocationResult: lat: ${location.latitude} ; lon: ${location.longitude}")
            }

        }
    }

    @SuppressLint("MissingSuperCall")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        Log.d(TAG, "onRequestPermissionResult: $requestCode")

    }

    private fun checkPermission() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            MaterialAlertDialogBuilder(this)
                .setTitle("Нам нужны гео данные")
                .setMessage("Пожалуйста, разрешите доступ к геоданным, для продолжения работы приложения")
                .setPositiveButton("Ok") { _, _ ->
                    ActivityCompat.requestPermissions(
                        this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                        GEO_LOCATION_REQUEST_COD_SUCCESS
                    )
                    ActivityCompat.requestPermissions(
                        this, arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
                        GEO_LOCATION_REQUEST_COD_SUCCESS
                    )

                }
                .setNegativeButton("Cancel") {dialog,_ -> dialog.dismiss()}
                .create()
                .show()
        }
    }
}