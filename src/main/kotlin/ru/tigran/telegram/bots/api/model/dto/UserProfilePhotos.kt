package ru.tigran.telegram.bots.api.model.dto

data class UserProfilePhotos(
    val totalCount: Int,
    val photos: List<List<PhotoSize>>,
)
