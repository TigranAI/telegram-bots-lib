package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest

data class SetChatDescriptionRequest(
    val chatId: String,
    val description: String? = null,
) : TelegramRequest
