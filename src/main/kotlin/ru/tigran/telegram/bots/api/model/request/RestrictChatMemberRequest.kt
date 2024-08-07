package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest
import ru.tigran.telegram.bots.api.model.dto.ChatPermissions

data class RestrictChatMemberRequest(
    val chatId: String,
    val userId: Long,
    val permissions: ChatPermissions,
    val useIndependentChatPermissions: Boolean? = null,
    val untilDate: Long? = null,
) : TelegramRequest
