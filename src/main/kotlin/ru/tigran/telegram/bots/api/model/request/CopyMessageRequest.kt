package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.dto.MessageEntity
import ru.tigran.telegram.bots.api.model.dto.ReplyMarkup
import ru.tigran.telegram.bots.api.model.dto.ReplyParameters
import ru.tigran.telegram.bots.api.model.enums.ParseModeType

data class CopyMessageRequest(
    val chatId: String,
    val fromChatId: String,
    val messageId: Long,
    val messageThreadId: Long? = null,
    val caption: String? = null,
    val parseMode: ParseModeType? = null,
    val captionEntities: List<MessageEntity>? = null,
    val showCaptionAboveMedia: Boolean? = null,
    val disableNotification: Boolean? = null,
    val protectContent: Boolean? = null,
    val replyParameters: ReplyParameters? = null,
    val replyMarkup: ReplyMarkup? = null,
)
