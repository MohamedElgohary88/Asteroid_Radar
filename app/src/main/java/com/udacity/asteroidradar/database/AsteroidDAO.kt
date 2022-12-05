package com.udacity.asteroidradar.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.udacity.asteroidradar.Asteroid

@Dao
interface AsteroidDAO {

    @Query("SELECT * FROM asteroid_table WHERE closeApproachDate <=:date ORDER BY date(closeApproachDate)")
    fun getTodayAsteroid(date: String): LiveData<List<Asteroid>>

    @Query("SELECT * FROM asteroid_table ORDER BY date(closeApproachDate) ASC")
    fun getAll(): LiveData<List<Asteroid>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(asteroids: List<Asteroid>): List<Long>

    @Transaction
    fun updateData(asteroids: List<Asteroid>): List<Long> {
        deleteAll()
        return insertAll(asteroids)
    }

    @Query("DELETE  FROM asteroid_table")
    fun deleteAll()

}