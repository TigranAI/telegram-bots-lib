package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest
import ru.tigran.telegram.bots.api.model.dto.InputFile
import ru.tigran.telegram.bots.api.model.dto.MessageEntity
import ru.tigran.telegram.bots.api.model.dto.ReplyMarkup
import ru.tigran.telegram.bots.api.model.dto.ReplyParameters
import ru.tigran.telegram.bots.api.model.enums.ParseModeType

data class SendVoiceRequest(
    val chatId: String,
    val voice: InputFile,
    val businessConnectionId: String? = null,
    val messageThreadId: Long? = null,
    val caption: String? = null,
    val parseMode: ParseModeType? = null,
    val captionEntities: List<MessageEntity>? = null,
    val duration: Int? = null,
    val disableNotification: Boolean? = null,
    val protectContent: Boolean? = null,
    val messageEffectId: Boolean? = null,
    val replyParameters: ReplyParameters? = null,
    val replyMarkup: ReplyMarkup? = null,
) : TelegramRequest
