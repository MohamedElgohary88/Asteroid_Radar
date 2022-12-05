package com.udacity.asteroidradar.manager

import android.app.Application
import android.os.Build
import androidx.work.*
import androidx.work.WorkManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class WorkManager: Application(){
    private val applicationScope = CoroutineScope(Dispatchers.Default)

    private fun delayedInit() {
        applicationScope.launch {
            setupWork()
        }
    }

    private fun setupWork() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.UNMETERED)
            .setRequiresBatteryNotLow(true)
            .setRequiresCharging(true)
            .apply {
                setRequiresDeviceIdle(true)
            }.build()

        val repeatingRequest
                = PeriodicWorkRequestBuilder<Refresher>(1, TimeUnit.DAYS)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance().enqueueUniquePeriodicWork(
            Refresher.Refresh_NAME,
            ExistingPeriodicWorkPolicy.KEEP,
            repeatingRequest)
    }


    override fun onCreate() {
        super.onCreate()
        delayedInit()
    }
}