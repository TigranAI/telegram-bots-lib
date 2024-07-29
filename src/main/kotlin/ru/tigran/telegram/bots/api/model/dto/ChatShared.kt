package ru.tigran.telegram.bots.api.model.dto

data class ChatShared(
    val requestId: Long,
    val chatId: Long,
    val title: String?,
    val username: String?,
    val photo: List<PhotoSize>?,
)
