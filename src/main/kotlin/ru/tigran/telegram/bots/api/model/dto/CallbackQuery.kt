package ru.tigran.telegram.bots.api.model.dto

data class CallbackQuery(
    val id: String,
    val from: User,
    val message: MessageUnsealed?,
    val inlineMessageId: String?,
    val chatInstance: String,
    val data: String?,
    val gameShortName: String?,
)
