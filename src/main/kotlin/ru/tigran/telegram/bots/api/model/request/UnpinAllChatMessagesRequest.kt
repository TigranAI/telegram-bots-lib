package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest

data class UnpinAllChatMessagesRequest(
    val chatId: String,
) : TelegramRequest
