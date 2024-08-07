package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest

data class UnpinChatMessageRequest(
    val chatId: String,
    val messageId: Long? = null,
    val businessConnectionId: String? = null,
) : TelegramRequest
