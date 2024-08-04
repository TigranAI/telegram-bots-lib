package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest

data class CopyMessagesRequest(
    val chatId: String,
    val fromChatId: String,
    val messageIds: List<Long>,
    val messageThreadId: Long? = null,
    val disableNotification: Boolean? = null,
    val protectContent: Boolean? = null,
    val removeCaption: Boolean? = null,
) : TelegramRequest
