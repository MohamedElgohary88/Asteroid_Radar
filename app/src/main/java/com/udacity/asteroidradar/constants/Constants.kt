package com.udacity.asteroidradar.constants

import java.text.SimpleDateFormat
import java.util.*

object Constants {
    const val API_QUERY_DATE_FORMAT = "YYYY-MM-dd"
    const val DEFAULT_END_DATE_DAYS = 7

    const val BASE_URL = "https://api.nasa.gov/"
    const val API_KEY_PIC = "planetary/apod?api_key=rad7P9Eps8Y34dXFvk6MZqkcaJUd6p7d4Pypq52U"
    const val API_KEY_Astreo = "neo/rest/v1/feed?&api_key=rad7P9Eps8Y34dXFvk6MZqkcaJUd6p7d4Pypq52U"

    fun getCurrentDate(): String {
        val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val date = Date()
        return format.format(date)
    }
}