package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest

data class ForwardMessagesRequest(
    val chatId: String,
    val fromChatId: String,
    val messageIds: List<Long>,
    val messageThreadId: Long? = null,
    val disableNotification: Boolean? = null,
    val protectContent: Boolean? = null,
) : TelegramRequest
