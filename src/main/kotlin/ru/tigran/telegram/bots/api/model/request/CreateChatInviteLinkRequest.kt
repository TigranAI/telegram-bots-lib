package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest

data class CreateChatInviteLinkRequest(
    val chatId: String,
    val name: String? = null,
    val expireDate: Long? = null,
    val memberLimit: Int? = null,
    val createsJoinRequest: Boolean? = null,
) : TelegramRequest
