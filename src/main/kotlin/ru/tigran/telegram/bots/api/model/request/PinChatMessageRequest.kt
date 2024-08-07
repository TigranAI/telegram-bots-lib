package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest

data class PinChatMessageRequest(
    val chatId: String,
    val messageId: Long,
    val businessConnectionId: String? = null,
    val disableNotification: Boolean? = null,
) : TelegramRequest
