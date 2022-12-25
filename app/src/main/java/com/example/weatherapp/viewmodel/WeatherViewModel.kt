package com.example.weatherapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.Thread.sleep

class WeatherViewModel(val liveData: MutableLiveData<AppState> = MutableLiveData<AppState>()): ViewModel() {


    fun sendRequest() {
        liveData.value = AppState.Loading
        Thread{
            sleep(2000L)
            liveData.postValue(AppState.Success(Any()))
        }.start()
    }


}