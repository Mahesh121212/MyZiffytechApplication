package com.myziffytechapplication.com.domain.use_case.get_weather_list

import com.myziffytechapplication.com.commonFile.Resource
import com.myziffytechapplication.com.data.interfaces.dao.toWeather
import com.myziffytechapplication.com.domain.model.Weather
import com.myziffytechapplication.com.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetWeatherListUseCase @Inject constructor(
    private val repository: WeatherRepository
) {

    operator fun invoke(): Flow<Resource<List<Weather>>> = flow {
        try {
            emit(Resource.Loading<List<Weather>>())
            val weatherList = repository.getWeatherList().map { it.toWeather() }
            emit(Resource.Success(weatherList))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Weather>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Weather>>("Couldn't reach server. Check your internet connection"))
        }
    }
}