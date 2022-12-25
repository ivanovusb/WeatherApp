package com.example.weatherapp.view.weatherlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.databinding.FragmentWeatherBinding
import com.example.weatherapp.viewmodel.AppState
import com.example.weatherapp.viewmodel.WeatherViewModel

class WeatherFragment : Fragment() {

    companion object {
//        fun newInstance():Fragment {
//            return WeatherFragment()
//        }

        fun newInstance() = WeatherFragment()
    }

    lateinit var binding: FragmentWeatherBinding
    lateinit var viewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeatherBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[WeatherViewModel::class.java]
        (viewModel as WeatherViewModel).liveData.observe(viewLifecycleOwner, object : Observer<AppState> {
            override fun onChanged(t: AppState) {
                Toast.makeText(requireContext(), "Работает $t", Toast.LENGTH_SHORT).show()
            }

        })
        (viewModel as WeatherViewModel).sendRequest()
    }


}