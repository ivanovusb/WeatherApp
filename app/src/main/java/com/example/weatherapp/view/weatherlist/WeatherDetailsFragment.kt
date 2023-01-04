package com.example.weatherapp.view.weatherlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.databinding.FragmentWeatherDetailsBinding
import com.example.weatherapp.viewmodel.AppState
import com.example.weatherapp.viewmodel.WeatherViewModel

class WeatherDetailsFragment : Fragment() {

    companion object {
//        fun newInstance():Fragment {
//            return WeatherDetailsFragment()
//        }

        fun newInstance() = WeatherDetailsFragment()
    }

    lateinit var binding: FragmentWeatherDetailsBinding
    lateinit var viewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeatherDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[WeatherViewModel::class.java]
        (viewModel as WeatherViewModel).getLiveData().observe(viewLifecycleOwner, object : Observer<AppState> {
            override fun onChanged(t: AppState) {
                renderData(t)
            }

        })
        (viewModel as WeatherViewModel).sendRequest()
    }

    private fun renderData(appState: AppState) {
        when(appState) {
            is AppState.Error -> {

            }
            AppState.Loading -> {

            }
            is AppState.Success -> {
                val result = appState.weatherData
                binding.cityName.text = result.city.name
                binding.temperatureValue.text = result.temperature.toString()
                binding.feelsLikeValue.text = result.feelsLike.toString()
                binding.cityCoordinates.text = "${result.city.lat} / ${result.city.lon}"
            }
        }
    }


}