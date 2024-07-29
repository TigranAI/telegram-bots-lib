package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.enums.ChatType

data class InlineQuery(
    val id: String,
    val from: User,
    val query: String,
    val offset: String?,
    val chatType: ChatType,
    val location: Location?,
)
