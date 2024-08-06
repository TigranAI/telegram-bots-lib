package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest
import ru.tigran.telegram.bots.api.model.dto.InputMedia
import ru.tigran.telegram.bots.api.model.dto.ReplyParameters

data class SendMediaGroupRequest(
    val chatId: String,
    val media: List<InputMedia>,
    val businessConnectionId: String? = null,
    val messageThreadId: Long? = null,
    val disableNotification: Boolean? = null,
    val protectContent: Boolean? = null,
    val messageEffectId: String? = null,
    val replyParameters: ReplyParameters? = null,
) : TelegramRequest
