package ru.tigran.telegram.bots.api.model.dto

data class Game(
    val title: String,
    val description: String,
    val photo: List<PhotoSize>,
    val text: String?,
    val textEntities: List<MessageEntity>?,
    val animation: Animation?,
)
