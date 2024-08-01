package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.enums.ParseModeType

data class ReplyParameters(
    val messageId: Long,
    val chatId: String?,
    val allowSendingWithoutReply: Boolean?,
    val quote: String?,
    val quoteParseMode: ParseModeType?,
    val quoteEntities: List<MessageEntity>?,
    val quotePosition: Int?,
)
