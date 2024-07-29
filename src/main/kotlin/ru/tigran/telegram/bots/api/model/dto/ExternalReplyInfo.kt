package ru.tigran.telegram.bots.api.model.dto

data class ExternalReplyInfo(
    val origin: MessageOrigin,
    val chat: Chat?,
    val messageId: Long?,
    val linkPreviewOptions: LinkPreviewOptions?,
)
