package ru.tigran.telegram.bots.api.model.dto

data class ProximityAlertTriggered(
    val traveler: User,
    val watcher: User,
    val distance: Int,
)
