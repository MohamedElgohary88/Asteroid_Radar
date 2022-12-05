package com.udacity.asteroidradar.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.constants.Constants
import com.udacity.asteroidradar.constants.Constants.API_KEY_PIC
import com.udacity.asteroidradar.constants.Constants.API_KEY_Astreo
import com.udacity.asteroidradar.PictureOfDay
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit = Retrofit
    .Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(Constants.BASE_URL).build()


interface AsteroidApiService {
    @GET(API_KEY_PIC)
    suspend fun getPicOfTheDay(): PictureOfDay

    @GET(API_KEY_Astreo)
    suspend fun getAsteroid(): List<Asteroid>

}

object AsteroidAPI {
    val retrofitService: AsteroidApiService by lazy { retrofit.create(AsteroidApiService::class.java) }
}