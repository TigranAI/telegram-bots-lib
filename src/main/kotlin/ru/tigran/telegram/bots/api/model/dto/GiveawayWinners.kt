package ru.tigran.telegram.bots.api.model.dto

data class GiveawayWinners(
    val chat: Chat,
    val giveawayMessageId: Long,
    val winnersSelectionDate: Long,
    val winnerCount: Int,
    val winners: List<User>,
    val additionalChatCount: Int?,
    val premiumSubscriptionMonthCount: Int?,
    val unclaimedPrizeCount: Int?,
    val onlyNewMembers: Boolean?,
    val wasRefunded: Boolean?,
    val prizeDescription: String?,
)
