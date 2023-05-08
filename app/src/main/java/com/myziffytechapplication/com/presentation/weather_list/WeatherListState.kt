package com.myziffytechapplication.com.presentation.weather_list

import com.myziffytechapplication.com.domain.model.Weather

data class WeatherListState(
    val isLoading: Boolean = false,
    val weatherList: List<Weather> = emptyList(),
    val error: String = ""
)
