package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest
import ru.tigran.telegram.bots.api.model.dto.InputFile
import ru.tigran.telegram.bots.api.model.dto.MessageEntity
import ru.tigran.telegram.bots.api.model.dto.ReplyMarkup
import ru.tigran.telegram.bots.api.model.dto.ReplyParameters
import ru.tigran.telegram.bots.api.model.enums.ParseModeType

data class SendVideoRequest(
    val chatId: String,
    val video: InputFile,
    val businessConnectionId: String? = null,
    val messageThreadId: Long? = null,
    val duration: Int? = null,
    val width: Int? = null,
    val height: Int? = null,
    val thumbnail: InputFile? = null,
    val caption: String? = null,
    val parseMode: ParseModeType? = null,
    val captionEntities: List<MessageEntity>? = null,
    val showCaptionAboveMedia: Boolean? = null,
    val hasSpoiler: Boolean? = null,
    val supportsStreaming: Boolean? = null,
    val disableNotification: Boolean? = null,
    val protectContent: Boolean? = null,
    val messageEffectId: String? = null,
    val replyParameters: ReplyParameters? = null,
    val replyMarkup: ReplyMarkup? = null,
) : TelegramRequest
