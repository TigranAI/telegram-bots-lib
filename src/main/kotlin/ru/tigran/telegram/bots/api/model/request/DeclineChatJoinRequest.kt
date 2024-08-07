package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest

data class DeclineChatJoinRequest(
    val chatId: String,
    val userId: Long,
) : TelegramRequest
