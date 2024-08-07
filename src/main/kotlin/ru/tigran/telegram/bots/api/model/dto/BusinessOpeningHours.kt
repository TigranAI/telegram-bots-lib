package ru.tigran.telegram.bots.api.model.dto

data class BusinessOpeningHours(
    val timeZoneName: String,
    val openingHours: List<BusinessOpeningHoursInterval>,
)
