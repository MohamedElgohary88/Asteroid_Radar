package com.udacity.asteroidradar.repository

import androidx.lifecycle.LiveData
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.constants.Constants.getCurrentDate
import com.udacity.asteroidradar.api.AsteroidAPI
import com.udacity.asteroidradar.api.parseAsteroidsJsonResult
import com.udacity.asteroidradar.database.AsteroidDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject

class AsteroidRepository(private val database: AsteroidDatabase) {

    val asteroidList: LiveData<List<Asteroid>>
        get() = database.asteroidDao().getAll()

    val todayAsteroidList: LiveData<List<Asteroid>>
        get() = database.asteroidDao().getTodayAsteroid(getCurrentDate())

    suspend fun refreshAsteroidList() {
        withContext(Dispatchers.IO) {
            try {
                val data = AsteroidAPI.retrofitService.getAsteroid()
                //    parseAsteroidsJsonResult(JSONObject(AsteroidAPI.retrofitService.getAsteroid()))
                database.asteroidDao().insertAll(data)
                database.asteroidDao().updateData(data)
            } catch (e: Exception) {
            }
        }
    }
}