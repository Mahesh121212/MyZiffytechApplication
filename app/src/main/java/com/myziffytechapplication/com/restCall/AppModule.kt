package com.myziffytechapplication.com.restCall

import com.myziffytechapplication.com.commonFile.Constants
import com.myziffytechapplication.com.data.interfaces.OpenWeatherApi
import com.myziffytechapplication.com.data.repository.WeatherRepositoryImpl
import com.myziffytechapplication.com.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOpenWeatherApi(): OpenWeatherApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OpenWeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(api: OpenWeatherApi): WeatherRepository {
        return WeatherRepositoryImpl(api)
    }
}