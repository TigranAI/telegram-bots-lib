package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest
import ru.tigran.telegram.bots.api.model.dto.ReplyMarkup
import ru.tigran.telegram.bots.api.model.dto.ReplyParameters

data class SendContactRequest(
    val chatId: String,
    val phoneNumber: String,
    val firstName: String,
    val businessConnectionId: String? = null,
    val messageThreadId: Long? = null,
    val lastName: String? = null,
    val vcard: String? = null,
    val disableNotification: Boolean? = null,
    val protectContent: Boolean? = null,
    val messageEffectId: String? = null,
    val replyParameters: ReplyParameters? = null,
    val replyMarkup: ReplyMarkup? = null,
) : TelegramRequest
