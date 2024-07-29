package ru.tigran.telegram.bots.api.model.dto

data class MessageReactionCountUpdated(
    val chat: Chat,
    val messageId: Long,
    val date: Long,
    val reactions: List<ReactionCount>,
)
