package ru.tigran.telegram.bots.api.model.dto

data class GiveawayCompletedUnsealed(
    val winnerCount: Int,
    val unclaimedPrizeCount: Int?,
    val giveawayMessage: MessageUnsealed?,
) {
    fun sealed() = GiveawayCompleted(
        winnerCount = winnerCount,
        unclaimedPrizeCount = unclaimedPrizeCount,
        giveawayMessage = giveawayMessage?.sealed(),
    )
}

data class GiveawayCompleted(
    val winnerCount: Int,
    val unclaimedPrizeCount: Int?,
    val giveawayMessage: Message?,
)
