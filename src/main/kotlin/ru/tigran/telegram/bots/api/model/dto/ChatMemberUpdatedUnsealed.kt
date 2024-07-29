package ru.tigran.telegram.bots.api.model.dto

data class ChatMemberUpdatedUnsealed(
    val chat: Chat,
    val from: User,
    val date: Long,
    val oldChatMember: ChatMemberUnsealed,
    val newChatMember: ChatMemberUnsealed,
    val inviteLink: ChatInviteLink?,
    val viaJoinRequest: Boolean?,
    val viaChatFolderInviteLink: Boolean?,
) {
    fun sealed() = ChatMemberUpdated(
        chat = chat,
        from = from,
        date = date,
        oldChatMember = oldChatMember.sealed(),
        newChatMember = newChatMember.sealed(),
        inviteLink = inviteLink,
        viaJoinRequest = viaJoinRequest,
        viaChatFolderInviteLink = viaChatFolderInviteLink,
    )
}

data class ChatMemberUpdated(
    val chat: Chat,
    val from: User,
    val date: Long,
    val oldChatMember: ChatMember,
    val newChatMember: ChatMember,
    val inviteLink: ChatInviteLink?,
    val viaJoinRequest: Boolean?,
    val viaChatFolderInviteLink: Boolean?,
)
