package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.TelegramRequest
import ru.tigran.telegram.bots.api.model.enums.ParseModeType

data class InputPollOption(
    val text: String,
    val textParseMode: ParseModeType? = null,
    val textEntities: List<MessageEntity>? = null,
) : TelegramRequest
