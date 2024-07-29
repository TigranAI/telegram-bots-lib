package ru.tigran.telegram.bots.api.model.dto

data class ForumTopicCreated(
    val name: String,
    val iconColor: Int,
    val iconCustomEmojiId: String?,
)
