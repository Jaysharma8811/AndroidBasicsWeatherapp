package com.example.shadiclonecom.services

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ServiceBuilder {
    //base url
    val url="https://api.openweathermap.org/data/2.5/"

    //create okhttp client
    val okHttp:OkHttpClient.Builder=OkHttpClient.Builder()



    //create retrofit builder
   val builder:Retrofit.Builder=Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).client(
        okHttp.build())


    //create Retrofit Instance
    val retrofit:Retrofit= builder.build()
    fun <T> buildService(serviceType:Class<T>):T{
        return retrofit.create(serviceType)
    }

}

