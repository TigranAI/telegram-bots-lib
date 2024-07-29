package ru.tigran.telegram.bots.api.model.dto

data class ChatJoinRequest(
    val chat: Chat,
    val from: User,
    val userChatId: Long,
    val date: Long,
    val bio: String?,
    val inviteLink: ChatInviteLink?,
)
