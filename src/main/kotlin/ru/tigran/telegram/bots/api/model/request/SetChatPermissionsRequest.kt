package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest
import ru.tigran.telegram.bots.api.model.dto.ChatPermissions

data class SetChatPermissionsRequest(
    val chatId: String,
    val permissions: ChatPermissions,
    val useIndependentChatPermissions: Boolean? = null,
) : TelegramRequest
