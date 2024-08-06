package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest
import ru.tigran.telegram.bots.api.model.enums.ChatAction

data class SendChatActionRequest(
    val chatId: String,
    val action: ChatAction,
    val businessConnectionId: String? = null,
    val messageThreadId: Long? = null,
) : TelegramRequest
