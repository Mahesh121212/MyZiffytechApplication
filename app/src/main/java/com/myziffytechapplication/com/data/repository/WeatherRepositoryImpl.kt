package com.myziffytechapplication.com.data.repository

import com.myziffytechapplication.com.data.interfaces.OpenWeatherApi
import com.myziffytechapplication.com.data.interfaces.dao.WeatherDto
import com.myziffytechapplication.com.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: OpenWeatherApi
): WeatherRepository {

    override suspend fun getWeatherList(): List<WeatherDto> {
        return api.getCityInfo().list
    }
}