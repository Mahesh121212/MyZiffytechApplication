package com.myziffytechapplication.com.data.interfaces

import com.myziffytechapplication.com.data.interfaces.dao.CityInfoDao
import retrofit2.http.GET

interface OpenWeatherApi {

    @GET("/data/2.5/forecast/daily?q=Paris&mode=json&units=metric&cnt=16&APPID=648a3aac37935e5b45e09727df728ac2")
    suspend fun getCityInfo(): CityInfoDao
}