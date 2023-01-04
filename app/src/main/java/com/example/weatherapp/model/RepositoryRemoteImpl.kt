package com.example.weatherapp.model

import com.example.weatherapp.domain.Weather
import com.example.weatherapp.viewmodel.AppState

class RepositoryRemoteImpl: Repository {
    override fun getListWeather(): List<Weather> {
        Thread {
            Thread.sleep(2000L)
        }.start()
        return listOf(Weather())
    }

    override fun getWeather(lat: Double, lon: Double): Weather {
        return Weather()
    }
}