package ru.tigran.telegram.bots.api.model.dto

data class SharedUser(
    val userId: Long,
    val firstName: String?,
    val lastName: String?,
    val username: String?,
    val photo: List<PhotoSize>?,
)
