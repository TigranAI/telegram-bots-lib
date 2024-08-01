package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.enums.ReactionType

data class ReactionApi(
    val type: ReactionType,
    val emoji: String?,
    val customEmojiId: String?,
) : ApiGodDto<Reaction> {
    override fun typify() = when (type) {
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

interface Reaction {
    val type: ReactionType

    data class ReactionTypeEmoji(
        override val type: ReactionType,
        val emoji: String,
    ) : Reaction

    data class ReactionTypeCustomEmoji(
        override val type: ReactionType,
        val customEmojiId: String,
    ) : Reaction
}