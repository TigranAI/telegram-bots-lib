package ru.tigran.telegram.bots.api.model.dto

data class MessageReactionUpdatedUnsealed(
    val chat: Chat,
    val messageId: Long,
    val user: User?,
    val actorChat: Chat?,
    val date: Long,
    val oldReaction: List<ReactionUnsealed>,
    val newReaction: List<ReactionUnsealed>,
) {
    fun sealed() = MessageReactionUpdated(
        chat = chat,
        messageId = messageId,
        user = user,
        actorChat = actorChat,
        date = date,
        oldReaction = oldReaction.map { it.sealed() },
        newReaction = newReaction.map { it.sealed() }
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