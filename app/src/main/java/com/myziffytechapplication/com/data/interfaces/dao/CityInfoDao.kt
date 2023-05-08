package com.myziffytechapplication.com.data.interfaces.dao

data class CityInfoDao(
    val city: CityDao,
    val cnt: Int,
    val cod: String,
    val list: List<WeatherDto>,
    val message: Double
)