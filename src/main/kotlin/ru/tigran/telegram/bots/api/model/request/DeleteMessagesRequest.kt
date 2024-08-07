package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest

data class DeleteMessagesRequest(
    val chatId: String,
    val messageIds: List<Long>,
) : TelegramRequest
