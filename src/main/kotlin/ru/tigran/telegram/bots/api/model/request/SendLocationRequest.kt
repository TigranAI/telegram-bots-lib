package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest
import ru.tigran.telegram.bots.api.model.dto.ReplyMarkup
import ru.tigran.telegram.bots.api.model.dto.ReplyParameters

data class SendLocationRequest(
    val chatId: String,
    val latitude: Float,
    val longitude: Float,
    val businessConnectionId: String? = null,
    val messageThreadId: Long? = null,
    val horizontalAccuracy: Float? = null,
    val livePeriod: Int? = null,
    val heading: Int? = null,
    val proximityAlertRadius: Int? = null,
    val disableNotification: Boolean? = null,
    val protectContent: Boolean? = null,
    val messageEffectId: String? = null,
    val replyParameters: ReplyParameters? = null,
    val replyMarkup: ReplyMarkup? = null,
) : TelegramRequest
