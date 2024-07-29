package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.enums.ChatType

data class Chat(
    val id: Long,
    val type: ChatType,
    val title: String?,
    val username: String?,
    val firstName: String?,
    val lastName: String?,
    val isForum: Boolean?,
)
