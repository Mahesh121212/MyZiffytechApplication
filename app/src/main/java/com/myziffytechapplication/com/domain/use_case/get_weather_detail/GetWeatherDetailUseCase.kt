package com.myziffytechapplication.com.domain.use_case.get_weather_detail

import com.myziffytechapplication.com.commonFile.Resource
import com.myziffytechapplication.com.data.interfaces.dao.toWeather
import com.myziffytechapplication.com.domain.model.Weather
import com.myziffytechapplication.com.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetWeatherDetailUseCase @Inject constructor(
    private val repository: WeatherRepository
) {

    operator fun invoke(date: Int): Flow<Resource<Weather>> = flow {
        try {
            emit(Resource.Loading<Weather>())
            val weather = repository.getWeatherList().find { it.dt == date }!!.toWeather()
            emit(Resource.Success(weather))
        } catch (e: HttpException) {
            emit(Resource.Error<Weather>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<Weather>("Couldn't reach server. Check your internet connection"))
        }
    }
}