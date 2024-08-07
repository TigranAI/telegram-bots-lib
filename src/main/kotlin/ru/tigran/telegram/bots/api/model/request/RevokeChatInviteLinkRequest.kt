package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest

data class RevokeChatInviteLinkRequest(
    val chatId: String,
    val inviteLink: String,
) : TelegramRequest
