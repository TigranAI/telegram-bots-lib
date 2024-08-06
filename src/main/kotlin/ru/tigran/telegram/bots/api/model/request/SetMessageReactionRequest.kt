package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest
import ru.tigran.telegram.bots.api.model.dto.Reaction

data class SetMessageReactionRequest(
    val chatId: String,
    val messageId: Long,
    val reaction: List<Reaction>? = null,
    val isBig: Boolean? = null,
) : TelegramRequest
