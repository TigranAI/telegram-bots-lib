package ru.tigran.telegram.bots.api.model.dto

data class InlineKeyboardButton(
    val text: String,
    val url: String?,
    val callbackData: String?,
    val webApp: WebAppInfo?,
    val loginUrl: LoginUrl?,
    val switchInlineQuery: String?,
    val switchInlineQueryCurrentChat: String?,
    val switchInlineQueryChosenChat: SwitchInlineQueryChosenChat?,
    val callbackGame: CallbackGame?,
    val pay: Boolean?,
)
