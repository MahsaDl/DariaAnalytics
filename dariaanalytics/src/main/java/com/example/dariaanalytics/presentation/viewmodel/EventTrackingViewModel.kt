package com.example.dariaanalytics.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dariaanalytics.data.remote.DariaAnalyticsApi
import com.example.dariaanalytics.domain.model.Event
import com.example.dariaanalytics.domain.model.EventParam
import com.example.dariaanalytics.domain.model.EventPayload
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EventTrackingViewModel : ViewModel() {

    private val _appInstanceId = MutableLiveData<String>()
    private val appInstanceId: LiveData<String> = _appInstanceId

    fun setAppInstanceId( appInstanceId: String) {
        _appInstanceId.value =  appInstanceId
    }


    fun trackEvent(dariaAnalyticsApi: DariaAnalyticsApi) {
        val appInstanceId = appInstanceId.value ?: return
        val eventPayload = EventPayload(
            app_instance_id = appInstanceId,
            non_personalized_ads = false,
            events = listOf(
                Event(
                    name = "tutorial_begin",
                    params = EventParam(params = "test_222")
                )
            )
        )
        val call = dariaAnalyticsApi.sendEvent(eventPayload)
        call.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    Log.e("md", "Event sent successfully: ", )
                    // Event sent successfully
                } else {
                    Log.e("md", "Event sent successfully: ", )
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Log.e("md", "Event not sent successfully: ", )
            }
        })
    }
}