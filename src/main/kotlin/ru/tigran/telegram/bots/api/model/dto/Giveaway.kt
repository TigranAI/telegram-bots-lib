package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.enums.CountryCode

data class Giveaway(
    val chats: List<Chat>,
    val winnersSelectionDate: Long,
    val winnerCount: Int,
    val onlyNewMembers: Boolean?,
    val hasPublicWinners: Boolean?,
    val prizeDescription: String?,
    val countryCodes: List<CountryCode>?,
    val premiumSubscriptionMonthCount: Int?,
)
