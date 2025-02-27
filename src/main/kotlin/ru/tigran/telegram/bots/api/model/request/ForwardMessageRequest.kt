package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest

data class ForwardMessageRequest(
    val chatId: String,
    val fromChatId: String,
    val messageId: Long,
    val messageThreadId: Long? = null,
    val disableNotification: Boolean? = null,
    val protectContent: Boolean? = null,
) : TelegramRequest
