package com.myziffytechapplication.com.domain.repository

import com.myziffytechapplication.com.data.interfaces.dao.WeatherDto

interface WeatherRepository {
    suspend fun getWeatherList(): List<WeatherDto>
}