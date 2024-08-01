package ru.tigran.telegram.bots.api.model.request

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.tigran.telegram.bots.api.model.dto.InputFile
import ru.tigran.telegram.bots.api.model.dto.MessageEntity
import ru.tigran.telegram.bots.api.model.dto.ReplyMarkup
import ru.tigran.telegram.bots.api.model.dto.ReplyParameters
import ru.tigran.telegram.bots.api.model.enums.ParseModeType
import ru.tigran.telegram.bots.util.TelegramInputFileConverter

data class SendPhotoRequest(
    val chatId: String,
    @field:JsonSerialize(converter = TelegramInputFileConverter::class)
    val photo: InputFile,
    val businessConnectionId: String? = null,
    val messageThreadId: Long? = null,
    val caption: String? = null,
    val parseMode: ParseModeType? = null,
    val captionEntities: List<MessageEntity>? = null,
    val showCaptionAboveMedia: Boolean? = null,
    val hasSpoiler: Boolean? = null,
    val disableNotification: Boolean? = null,
    val protectContent: Boolean? = null,
    val messageEffectId: String? = null,
    val replyParameters: ReplyParameters? = null,
    val replyMarkup: ReplyMarkup? = null,
)
