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
            source = source,
            user = user!!,
        )
        ChatBoostSourceType.GIFT_CODE -> ChatBoostSource.ChatBoostSourceGift(
            source = source,
            user = user!!,
        )
        ChatBoostSourceType.GIVEAWAY -> ChatBoostSource.ChatBoostSourceGiveaway(
            source = source,
            giveawayMessageId = giveawayMessageId!!,
            user = user,
            isUnclaimed = isUnclaimed,
        )
    }
}

interface ChatBoostSource {
    val source: ChatBoostSourceType

    data class ChatBoostSourcePremium(
        override val source: ChatBoostSourceType,
        val user: User,
    ) : ChatBoostSource

    data class ChatBoostSourceGift(
        override val source: ChatBoostSourceType,
        val user: User,
    ) : ChatBoostSource

    data class ChatBoostSourceGiveaway(
        override val source: ChatBoostSourceType,
        val giveawayMessageId: Long,
        val user: User?,
        val isUnclaimed: Boolean?,
    ) : ChatBoostSource
}
