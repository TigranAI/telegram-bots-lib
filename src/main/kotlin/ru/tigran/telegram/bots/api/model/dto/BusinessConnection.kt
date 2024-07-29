package ru.tigran.telegram.bots.api.model.dto

data class BusinessConnection(
    val id: String,
    val user: User,
    val userChatId: Long,
    val date: Long,
    val canReply: Boolean,
    val isEnabled: Boolean,
)
