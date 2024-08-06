package ru.tigran.telegram.bots.util.converter

import com.fasterxml.jackson.databind.util.StdConverter
import ru.tigran.telegram.bots.api.model.enums.DiceEmoji

class TelegramDiceEmojiConverter : StdConverter<DiceEmoji, String?>() {
    override fun convert(value: DiceEmoji?): String? {
        return value?.emoji
    }
}