package ru.tigran.telegram.bots.api.model.dto

data class BusinessMessagesDeleted(
    val businessConnectionId: String,
    val chat: Chat,
    val messageIds: List<Long>,
)
