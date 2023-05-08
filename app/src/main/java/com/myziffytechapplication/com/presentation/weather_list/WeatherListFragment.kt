package com.myziffytechapplication.com.presentation.weather_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.viewbinding.ViewBinding
import com.myziffytechapplication.com.databinding.FragmentWeatherListBinding
import com.myziffytechapplication.com.domain.model.Weather
import com.myziffytechapplication.com.presentation.BindingFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class WeatherListFragment : BindingFragment<FragmentWeatherListBinding>() {

    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentWeatherListBinding::inflate

    private val viewModel: WeatherListViewModel by viewModels()
    private val adapter: WeatherAdapter by lazy { WeatherAdapter(layoutInflater, ::onWeatherClick) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        subscribeToStates()
    }

    private fun subscribeToStates() {
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect { state ->
                when (state.isLoading) {
                    true -> binding.progressBar.visibility = View.VISIBLE
                    false -> binding.progressBar.visibility = View.GONE
                }

                when (state.weatherList.isNotEmpty()) {
                    true -> adapter.add(state.weatherList)

                    else -> {}
                }

                when (state.error.isNotEmpty()) {
                    true -> Toast.makeText(context, state.error, Toast.LENGTH_LONG).show()
                    else -> {}
                }

            }
        }
    }

    private fun onWeatherClick(weather: Weather) {
        val action = WeatherListFragmentDirections.actionWeatherListFragmentToWeatherDetailFragment(weather.dt)
        view?.findNavController()?.navigate(action)
    }
}