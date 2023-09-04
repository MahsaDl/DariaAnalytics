package com.example.dariaanalytics.data.remote

import com.example.dariaanalytics.domain.model.EventPayload
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface DariaAnalyticsApi {

    companion object {
        const val BASE_URL = "https://www.google-analytics.com/"
    }

    @POST("mp/collect?api_secret=pFB-5c4sQQCL1sRvNVRrYQ&firebase_app_id=1:581628578372:android:a2824b6109afbed02c0a11")
    fun sendEvent(@Body payload: EventPayload): Call<Void>
}