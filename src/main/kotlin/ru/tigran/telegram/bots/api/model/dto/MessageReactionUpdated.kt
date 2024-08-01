package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.ApiGodDto

data class MessageReactionUpdatedApi(
    val chat: Chat,
    val messageId: Long,
    val user: User?,
    val actorChat: Chat?,
    val date: Long,
    val oldReaction: List<ReactionApi>,
    val newReaction: List<ReactionApi>,
) : ApiGodDto<MessageReactionUpdated> {
    override fun typify() = MessageReactionUpdated(
        chat = chat,
        messageId = messageId,
        user = user,
        actorChat = actorChat,
        date = date,
        oldReaction = oldReaction.map { it.typify() },
        newReaction = newReaction.map { it.typify() }
    )
}

data class MessageReactionUpdated(
    val chat: Chat,
    val messageId: Long,
    val user: User?,
    val actorChat: Chat?,
    val date: Long,
    val oldReaction: List<Reaction>,
    val newReaction: List<Reaction>,
)