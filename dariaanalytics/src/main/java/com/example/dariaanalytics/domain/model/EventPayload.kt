package com.example.dariaanalytics.domain.model

data class EventPayload(
    val app_instance_id: String,
    val non_personalized_ads: Boolean,
    val events: List<Event>
)