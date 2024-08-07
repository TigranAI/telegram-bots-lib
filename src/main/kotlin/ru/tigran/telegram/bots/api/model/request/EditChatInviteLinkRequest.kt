package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest

data class EditChatInviteLinkRequest(
    val chatId: String,
    val inviteLink: String,
    val name: String? = null,
    val expireDate: Long? = null,
    val memberLimit: Int? = null,
    val createsJoinRequest: Boolean? = null,
) : TelegramRequest
