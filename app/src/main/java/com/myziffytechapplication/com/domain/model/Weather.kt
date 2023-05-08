package com.myziffytechapplication.com.domain.model

data class Weather(
    val dt: Int,
    val day: Double,
    val night: Double,
    val title: String,
    val description: String,
    val icon: String,
)
