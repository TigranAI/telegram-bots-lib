package ru.tigran.telegram.bots.api.model.dto

data class MessageReactionUpdated(
    val chat: Chat,
    val messageId: Long,
    val user: User?,
    val actorChat: Chat?,
    val date: Long,
    val oldReaction: List<ReactionUnsealed>,
    val newReaction: List<ReactionUnsealed>,
)
