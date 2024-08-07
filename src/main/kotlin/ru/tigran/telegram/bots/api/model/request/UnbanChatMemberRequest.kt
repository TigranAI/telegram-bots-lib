package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest

data class UnbanChatMemberRequest(
    val chatId: String,
    val userId: Long,
    val onlyIfBanned: Boolean? = null,
) : TelegramRequest
