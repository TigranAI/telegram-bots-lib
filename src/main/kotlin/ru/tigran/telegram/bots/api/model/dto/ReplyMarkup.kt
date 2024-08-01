package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.ApiGodDto

data class ReplyMarkupApi(
    val inlineKeyboard: List<List<InlineKeyboardButton>>? = null,
) : ApiGodDto<ReplyMarkup> {
    override fun typify() = when {
        inlineKeyboard != null -> ReplyMarkup.InlineKeyboardMarkup(
            inlineKeyboard = inlineKeyboard,
        )
        else -> ReplyMarkup.UnknownMarkup()
    }
}

interface ReplyMarkup {
    data class InlineKeyboardMarkup(
        val inlineKeyboard: List<List<InlineKeyboardButton>>,
    ) : ReplyMarkup

    class UnknownMarkup : ReplyMarkup
}
