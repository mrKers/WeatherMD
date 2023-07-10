package com.example.weathermd

import android.app.Application
import android.content.Intent

const val APP_SETTINGS = "App settings"
const val IS_STARTED_UP = "Is started up"

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        val preferences = getSharedPreferences(APP_SETTINGS, MODE_PRIVATE)

        val flag = preferences.contains(IS_STARTED_UP)

        if(!flag){
            val intent = Intent(this,InitialActivity ::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}