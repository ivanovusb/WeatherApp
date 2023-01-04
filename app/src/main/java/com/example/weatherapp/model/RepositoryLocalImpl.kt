package com.example.weatherapp.model

import com.example.weatherapp.domain.Weather

class RepositoryLocalImpl: Repository {
    override fun getListWeather(): List<Weather> {
        return listOf(Weather())
    }

    override fun getWeather(lat: Double, lon: Double): Weather {
        return Weather()
    }
}