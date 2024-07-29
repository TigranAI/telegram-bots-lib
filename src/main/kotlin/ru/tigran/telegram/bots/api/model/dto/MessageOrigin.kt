package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.enums.MessageOriginType

data class MessageOrigin(
    val type: MessageOriginType,
    val date: Long,
    val senderUser: User?,
    val senderUserName: String?,
    val senderChat: Chat?,
    val authorSignature: String?,
    val messageId: Long?,
)