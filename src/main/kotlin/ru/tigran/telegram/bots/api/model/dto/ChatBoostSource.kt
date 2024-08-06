package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.ApiGodDto
import ru.tigran.telegram.bots.api.model.enums.ChatBoostSourceType

data class ChatBoostSourceApi(
    val source: ChatBoostSourceType,
    val user: User?,
    val giveawayMessageId: Long?,
    val isUnclaimed: Boolean?,
) : ApiGodDto<ChatBoostSource> {
    override fun typify() = when (source) {
        ChatBoostSourceType.PREMIUM -> ChatBoostSource.ChatBoostSourcePremium(
            user = user!!,
        )
        ChatBoostSourceType.GIFT_CODE -> ChatBoostSource.ChatBoostSourceGift(
            user = user!!,
        )
        ChatBoostSourceType.GIVEAWAY -> ChatBoostSource.ChatBoostSourceGiveaway(
            giveawayMessageId = giveawayMessageId!!,
            user = user,
            isUnclaimed = isUnclaimed,
        )
    }
}

interface ChatBoostSource {
    val source: ChatBoostSourceType

    data class ChatBoostSourcePremium(
        val user: User,
    ) : ChatBoostSource {
        override val source = ChatBoostSourceType.PREMIUM
    }

    data class ChatBoostSourceGift(
        val user: User,
    ) : ChatBoostSource {
        override val source = ChatBoostSourceType.GIFT_CODE
    }

    data class ChatBoostSourceGiveaway(
        val giveawayMessageId: Long,
        val user: User?,
        val isUnclaimed: Boolean?,
    ) : ChatBoostSource {
        override val source = ChatBoostSourceType.GIVEAWAY
    }
}
