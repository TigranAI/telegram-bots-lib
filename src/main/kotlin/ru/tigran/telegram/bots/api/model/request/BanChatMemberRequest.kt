package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest

data class BanChatMemberRequest(
    val chatId: String,
    val userId: Long,
    val untilDate: Long? = null,
    val revokeMessages: Boolean? = null,
) : TelegramRequest
