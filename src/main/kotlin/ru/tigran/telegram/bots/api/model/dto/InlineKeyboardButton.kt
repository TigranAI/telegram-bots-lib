package ru.tigran.telegram.bots.api.model.dto

data class InlineKeyboardButton(
    val text: String,
    val url: String? = null,
    val callbackData: String? = null,
    val webApp: WebAppInfo? = null,
    val loginUrl: LoginUrl? = null,
    val switchInlineQuery: String? = null,
    val switchInlineQueryCurrentChat: String? = null,
    val switchInlineQueryChosenChat: SwitchInlineQueryChosenChat? = null,
    val callbackGame: CallbackGame? = null,
    val pay: Boolean? = null,
)
