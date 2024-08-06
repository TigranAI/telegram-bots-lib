package ru.tigran.telegram.bots.api.model.request

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.tigran.telegram.bots.api.model.TelegramRequest
import ru.tigran.telegram.bots.api.model.dto.ReplyMarkup
import ru.tigran.telegram.bots.api.model.dto.ReplyParameters
import ru.tigran.telegram.bots.api.model.enums.DiceEmoji
import ru.tigran.telegram.bots.util.converter.TelegramDiceEmojiConverter

data class SendDiceRequest(
    val chatId: String,
    @field:JsonSerialize(converter = TelegramDiceEmojiConverter::class)
    val emoji: DiceEmoji? = DiceEmoji.GAME_DIE,
    val businessConnectionId: String? = null,
    val messageThreadId: Long? = null,
    val disableNotification: Boolean? = null,
    val protectContent: Boolean? = null,
    val messageEffectId: String? = null,
    val replyParameters: ReplyParameters? = null,
    val replyMarkup: ReplyMarkup? = null,
) : TelegramRequest
