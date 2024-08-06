package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.ApiGodDto
import ru.tigran.telegram.bots.api.model.enums.ReactionType

data class ReactionApi(
    val type: ReactionType,
    val emoji: String?,
    val customEmojiId: String?,
) : ApiGodDto<Reaction> {
    override fun typify() = when (type) {
        ReactionType.EMOJI -> Reaction.ReactionTypeEmoji(
            emoji = emoji!!,
        )
        ReactionType.CUSTOM_EMOJI -> Reaction.ReactionTypeCustomEmoji(
            customEmojiId = customEmojiId!!,
        )
    }
}

interface Reaction {
    val type: ReactionType

    data class ReactionTypeEmoji(
        val emoji: String,
    ) : Reaction {
        override val type = ReactionType.EMOJI
    }

    data class ReactionTypeCustomEmoji(
        val customEmojiId: String,
    ) : Reaction {
        override val type = ReactionType.CUSTOM_EMOJI
    }
}