package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest
import ru.tigran.telegram.bots.api.model.dto.BotCommand
import ru.tigran.telegram.bots.api.model.dto.BotCommandScope
import ru.tigran.telegram.bots.api.model.enums.CountryCode

data class SetMyCommandsRequest(
    val commands: List<BotCommand>,
    val scope: BotCommandScope? = null,
    val languageCode: CountryCode? = null,
) : TelegramRequest
