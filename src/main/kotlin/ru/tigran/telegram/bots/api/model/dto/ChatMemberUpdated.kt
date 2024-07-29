package ru.tigran.telegram.bots.api.model.dto

data class ChatMemberUpdated(
    val chat: Chat,
    val from: User,
    val date: Long,
    val oldChatMember: ChatMemberUnsealed,
    val newChatMember: ChatMemberUnsealed,
    val inviteLink: ChatInviteLink?,
    val viaJoinRequest: Boolean?,
    val viaChatFolderInviteLink: Boolean?,
)
