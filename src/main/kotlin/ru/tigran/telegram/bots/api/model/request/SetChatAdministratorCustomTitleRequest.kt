package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest

data class SetChatAdministratorCustomTitleRequest(
    val chatId: String,
    val userId: Long,
    val customTitle: String,
) : TelegramRequest
