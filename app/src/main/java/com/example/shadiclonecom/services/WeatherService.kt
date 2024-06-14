package com.example.shadiclonecom.services

import com.example.shadiclonecom.models.weather.WeatherApp
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface  WeatherService{
@GET("weather")
fun getWeather(@Query("q") cityName:String,@Query("appid") appid:String,@Query("units") units:String):Call<WeatherApp>
}