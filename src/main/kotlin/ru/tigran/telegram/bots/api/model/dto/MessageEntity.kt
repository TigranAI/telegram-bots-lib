package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.enums.MessageEntityType

data class MessageEntity(
    val type: MessageEntityType,
    val offset: Long,
    val length: Long,
    val url: String?,
    val user: User?,
    val language: String?,
    val customEmojiId: String?,
)
