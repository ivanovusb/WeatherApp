package com.example.weatherapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.model.Repository
import com.example.weatherapp.model.RepositoryLocalImpl
import com.example.weatherapp.model.RepositoryRemoteImpl
import java.lang.NullPointerException
import java.lang.Thread.sleep

class WeatherViewModel(
    private val liveData: MutableLiveData<AppState> = MutableLiveData<AppState>()
) : ViewModel() {

    lateinit var repository: Repository

    fun getLiveData(): MutableLiveData<AppState> {
        choiceRepository()
        return liveData
    }

    private fun choiceRepository() {
        repository = if (isConnection()) {
            RepositoryRemoteImpl()
        } else {
            RepositoryLocalImpl()
        }
    }


    fun sendRequest() {
        liveData.value = AppState.Loading
        if ((0..3).random()==1) {
            liveData.postValue(AppState.Error(throw IllegalStateException("Something gone wrong")))
        } else {
            liveData.postValue(AppState.Success(repository.getWeather(55.755826, 37.617299900000035)))
        }
    }

    private fun isConnection(): Boolean {
        return false
    }


}