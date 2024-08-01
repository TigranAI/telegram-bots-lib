package ru.tigran.telegram.bots.api.model.request

data class ForwardMessagesRequest(
    val chatId: String,
    val fromChatId: String,
    val messageIds: List<Long>,
    val messageThreadId: Long? = null,
    val disableNotification: Boolean? = null,
    val protectContent: Boolean? = null,
)
