package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.enums.ReactionType

data class ReactionUnsealed(
    val type: ReactionType,
    val emoji: String?,
    val customEmojiId: String?,
) {
    fun sealed() = when (type) {
        ReactionType.EMOJI -> Reaction.ReactionTypeEmoji(
            type = type,
            emoji = emoji!!,
        )
        ReactionType.CUSTOM_EMOJI -> Reaction.ReactionTypeCustomEmoji(
            type = type,
            customEmojiId = customEmojiId!!,
        )
    }
}

sealed class Reaction {
    class ReactionTypeEmoji(
        val type: ReactionType,
        val emoji: String,
    ) : Reaction()

    class ReactionTypeCustomEmoji(
        val type: ReactionType,
        val customEmojiId: String,
    ) : Reaction()
}