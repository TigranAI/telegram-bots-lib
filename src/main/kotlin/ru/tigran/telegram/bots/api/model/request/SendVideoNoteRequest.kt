package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest
import ru.tigran.telegram.bots.api.model.dto.InputFile
import ru.tigran.telegram.bots.api.model.dto.ReplyMarkup
import ru.tigran.telegram.bots.api.model.dto.ReplyParameters

data class SendVideoNoteRequest(
    val chatId: String,
    val videoNote: InputFile,
    val businessConnectionId: String? = null,
    val messageThreadId: Long? = null,
    val duration: Int? = null,
    val length: Int? = null,
    val disableNotification: Boolean? = null,
    val protectContent: Boolean? = null,
    val messageEffectId: Boolean? = null,
    val replyParameters: ReplyParameters? = null,
    val replyMarkup: ReplyMarkup? = null,
) : TelegramRequest
