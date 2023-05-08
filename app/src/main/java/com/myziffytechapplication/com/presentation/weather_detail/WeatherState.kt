package com.myziffytechapplication.com.presentation.weather_detail

import com.myziffytechapplication.com.domain.model.Weather

data class WeatherState(
    val isLoading: Boolean = false,
    val weather: Weather? = null,
    val error: String = ""
)
