package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.dto.LinkPreviewOptions
import ru.tigran.telegram.bots.api.model.dto.MessageEntity
import ru.tigran.telegram.bots.api.model.dto.ReplyMarkup
import ru.tigran.telegram.bots.api.model.dto.ReplyParameters
import ru.tigran.telegram.bots.api.model.enums.ParseModeType

data class SendMessageRequest(
    val chatId: String,
    val text: String,
    val businessConnectionId: String? = null,
    val messageThreadId: Long? = null,
    val parseMode: ParseModeType? = null,
    val entities: List<MessageEntity>? = null,
    val linkPreviewOptions: LinkPreviewOptions? = null,
    val disableNotification: Boolean? = null,
    val protectContent: Boolean? = null,
    val messageEffectId: String? = null,
    val replyParameters: ReplyParameters? = null,
    val replyMarkup: ReplyMarkup? = null,
)
