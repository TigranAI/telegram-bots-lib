package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.enums.ChatBoostSourceType

data class ChatBoostSourceUnsealed(
    val source: ChatBoostSourceType,
    val user: User?,
    val giveawayMessageId: Long?,
    val isUnclaimed: Boolean?,
) {
    fun sealed() = when (source) {
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

sealed class ChatBoostSource {
    class ChatBoostSourcePremium(
        val source: ChatBoostSourceType,
        val user: User,
    ) : ChatBoostSource()

    class ChatBoostSourceGift(
        val source: ChatBoostSourceType,
        val user: User,
    ) : ChatBoostSource()

    class ChatBoostSourceGiveaway(
        val source: ChatBoostSourceType,
        val giveawayMessageId: Long,
        val user: User?,
        val isUnclaimed: Boolean?,
    ) : ChatBoostSource()
}
