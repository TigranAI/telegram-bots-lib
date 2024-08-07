package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest

data class UnbanChatSenderChatRequest(
    val chatId: String,
    val senderChatId: Long,
) : TelegramRequest
