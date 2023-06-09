package com.myziffytechapplication.com.data.interfaces.dao

import com.google.gson.annotations.SerializedName
import com.myziffytechapplication.com.domain.model.Weather

data class WeatherDto(
    val clouds: Int,
    val deg: Int,
    val dt: Int,
    @SerializedName("feels_like")
    val feelsLike: ShiftDao,
    val gust: Double,
    val humidity: Int,
    val pop: Double,
    val pressure: Int,
    val speed: Double,
    val sunrise: Int,
    val sunset: Int,
    val temp: TempDao,
    @SerializedName("weather")
    val weatherInfo: List<WeatherInfoDao>
)

fun WeatherDto.toWeather(): Weather {
    return Weather(
        dt = dt,
        day = temp.day,
        night = temp.night,
        title = weatherInfo.firstOrNull()?.main ?: "",
        description = weatherInfo.firstOrNull()?.description ?: "",
        icon = weatherInfo.firstOrNull()?.icon ?: ""
    )
}