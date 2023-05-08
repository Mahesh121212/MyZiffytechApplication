package com.myziffytechapplication.com.data.interfaces.dao

data class CityDao(
    val coord: CoordinateDao,
    val country: String,
    val id: Int,
    val name: String,
    val population: Int,
    val timezone: Int
)