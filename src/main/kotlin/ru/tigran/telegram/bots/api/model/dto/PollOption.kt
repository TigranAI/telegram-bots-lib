package ru.tigran.telegram.bots.api.model.dto

data class PollOption(
    val text: String,
    val textEntities: List<MessageEntity>?,
    val voterCount: Int,
)
