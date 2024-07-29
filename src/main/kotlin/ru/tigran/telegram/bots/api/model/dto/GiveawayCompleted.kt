package ru.tigran.telegram.bots.api.model.dto

data class GiveawayCompleted(
    val winnerCount: Int,
    val unclaimedPrizeCount: Int?,
    val giveawayMessage: Message?,
)
