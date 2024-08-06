package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest
import ru.tigran.telegram.bots.api.model.dto.InputPollOption
import ru.tigran.telegram.bots.api.model.dto.MessageEntity
import ru.tigran.telegram.bots.api.model.dto.ReplyMarkup
import ru.tigran.telegram.bots.api.model.dto.ReplyParameters
import ru.tigran.telegram.bots.api.model.enums.ParseModeType
import ru.tigran.telegram.bots.api.model.enums.PollType

data class SendPollRequest(
    val chatId: String,
    val question: String,
    val options: List<InputPollOption>,
    val businessConnectionId: String? = null,
    val messageThreadId: Long? = null,
    val questionParseMode: ParseModeType? = null,
    val questionEntities: List<MessageEntity>? = null,
    val isAnonymous: Boolean? = null,
    val type: PollType? = null,
    val allowMultipleAnswers: Boolean? = null,
    val correctOptionId: Int? = null,
    val explanation: String? = null,
    val explanationParseMode: ParseModeType? = null,
    val explanationEntities: List<MessageEntity>? = null,
    val openPeriod: Int? = null,
    val closeDate: Int? = null,
    val isClosed: Boolean? = null,
    val disableNotification: Boolean? = null,
    val protectContent: Boolean? = null,
    val messageEffectId: String? = null,
    val replyParameters: ReplyParameters? = null,
    val replyMarkup: ReplyMarkup? = null,
) : TelegramRequest
