package ru.tigran.telegram.bots.api.model.dto

data class ChosenInlineResult(
    val resultId: String,
    val from: User,
    val location: Location?,
    val inlineMessageId: String?,
    val query: String,
)
