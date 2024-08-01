package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.ApiGodDto

data class ChatMemberUpdatedApi(
    val chat: Chat,
    val from: User,
    val date: Long,
    val oldChatMember: ChatMemberApi,
    val newChatMember: ChatMemberApi,
    val inviteLink: ChatInviteLink?,
    val viaJoinRequest: Boolean?,
    val viaChatFolderInviteLink: Boolean?,
) : ApiGodDto<ChatMemberUpdated> {
    override fun typify() = ChatMemberUpdated(
        chat = chat,
        from = from,
        date = date,
        oldChatMember = oldChatMember.typify(),
        newChatMember = newChatMember.typify(),
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
