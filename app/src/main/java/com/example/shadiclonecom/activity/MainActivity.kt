package com.example.shadiclonecom.activity

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import com.example.shadiclonecom.R
import com.example.shadiclonecom.models.weather.WeatherApp
import com.example.shadiclonecom.databinding.ActivityMainBinding
import com.example.shadiclonecom.services.ApiInterface
import com.example.shadiclonecom.services.ServiceBuilder
import com.example.shadiclonecom.services.WeatherService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    private   val channelId="AppNotification"
    private val description = "Test notification"
     lateinit var cityName:String;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notificationManager=getSystemService(Context.NOTIFICATION_SERVICE)as NotificationManager


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       fetchWeatherData("mathura", this)
//        fetchWeatherReport("Mathura",this)
        binding.box.setOnClickListener { val intent= Intent(this, RoomPractice::class.java)
            startActivity(intent) }
        searchCity(this)
    }

    private fun searchCity(context: Context) {

        val searchView=binding.mainActivitySearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {

                if (query!=null){
                    fetchWeatherData(query, context)
                }
                return  true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }

    private fun fetchWeatherData(cityName:String,context: Context) {
        val retrofit=Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .build().create(ApiInterface::class.java)
        val response=retrofit.
        getWeatherData(cityName,"aeac80eec860dfb05770fc4ffe48bd74","metric")
        response.enqueue(object : Callback<WeatherApp>{
            override fun onResponse(call: Call<WeatherApp>, response: Response<WeatherApp>) {
                val responseBody=response.body()
                if (response.isSuccessful&&responseBody!=null){
                    val humidity=responseBody.main.humidity.toString()
                    val seaLevel=responseBody.main.sea_level.toString()
                    val temp_max=responseBody.main.temp_max.toString()
                    val temp_min=responseBody.main.temp_min.toString()
                    val pressure=responseBody.main.pressure.toString()
                    val windSpeed=responseBody.wind.speed.toString()
                    val sunrise=responseBody.sys.sunrise.toString()
                    val sunset=responseBody.sys.sunset.toString()
                    val condition=responseBody.weather.firstOrNull()?.main?: "unknown"
                     this@MainActivity.cityName =responseBody.name.toString()
                    val countryName=responseBody.sys.country.toString()


                    val temprature=responseBody.main.temp.toString()
                    Log.d("TAG","onResponse:$temprature")
                    binding.mintempTextview.setText("$temprature °C")
                    binding.maxrealtempTextview.text="Max: $temp_max °C"
                    binding.minrealtempTextview.text="Min: $temp_min °C"
                    binding.humidityTextview.text="$humidity %"
                    binding.sealevelTextview.text="$seaLevel "
                    binding.windSpeedTextview.text="$windSpeed m/s"
                    binding.sunsetTextview.text="$sunset"
                    binding.sunriseTextView.text="$sunrise"
                    binding.weatherConditionTextView.text="$condition"
                    binding.weekDayTextview.text=dayName(System.currentTimeMillis())
                    binding.dateTextview.text=date()
                    binding.weathertypetempTextview.text="$condition"
                    binding.cityTextview.text="$cityName, $countryName"
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        notificationChannel = NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
                        notificationChannel.enableLights(true)
                        notificationChannel.lightColor = Color.RED
                        notificationChannel.enableVibration(false)
                        notificationManager.createNotificationChannel(notificationChannel)

                        builder = Notification.Builder(context, channelId)
                            .setContentText("THIS IS$cityName")
                            .setSmallIcon(R.drawable.ic_launcher_background)
                            .setLargeIcon(BitmapFactory.decodeResource(context.resources,
                                R.drawable.ic_launcher_background
                            ))
                    }else {

                        builder = Notification.Builder(context)
                            .setContentText("THIS IS$cityName ")
                            .setSmallIcon(R.drawable.ic_launcher_background)
                            .setLargeIcon(BitmapFactory.decodeResource(context.resources,
                                R.drawable.ic_launcher_background
                            ))
                    }

                    changeImageAccordingToWeather(condition)
                    notificationManager.notify(1,builder.build())




                }
            }

            override fun onFailure(call: Call<WeatherApp>, t: Throwable) {
            }
        })
    }


    private fun fetchWeatherReport(cityName: String,context: Context){
        //interface instance\
        val weatherService:WeatherService = ServiceBuilder.buildService(WeatherService::class.java)

        // request call
        val requestCall:Call<WeatherApp> = weatherService.getWeather(cityName,"j","ddd")

        requestCall.enqueue(object :Callback<WeatherApp>{
            override fun onResponse(call: Call<WeatherApp>, response: Response<WeatherApp>) {

            }

            override fun onFailure(call: Call<WeatherApp>, t: Throwable) {

            }

        })





    }
    private fun changeImageAccordingToWeather(conditions:String){
        when(conditions){
            "Clear Sky","Sunny","Clear"->{
                binding.root.setBackgroundResource(R.drawable.sunny_background)
                binding.lottieAnimationViewMain.setAnimation(R.raw.sun)
            }
            "Haze","Partly Clouds","Clouds","Overcast","Mist","Foggy"->{
                binding.root.setBackgroundResource(R.drawable.colud_background)
                binding.lottieAnimationViewMain.setAnimation(R.raw.cloud)
            }
            "Light Rain","Drizzle","Moderate Rain","Rain ","Showers","Heavy Rain"->{
                binding.root.setBackgroundResource(R.drawable.rain_background)
                binding.lottieAnimationViewMain.setAnimation(R.raw.rain)
            }
            "Light Snow","Moderate Snow","Heavy Snow","Blizzard"->{
                binding.root.setBackgroundResource(R.drawable.snow_background)
                binding.lottieAnimationViewMain.setAnimation(R.raw.snow)
            }
        }
        binding.lottieAnimationViewMain.playAnimation()
    }

    fun  dayName(timeStamp:Long):String{
        val  sdf=SimpleDateFormat("EEEE", Locale.getDefault())
        return sdf.format(Date())
    }
    fun  date():String{
        val  sdf=SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
        return sdf.format(Date())
    }
}