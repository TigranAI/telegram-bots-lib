package ru.tigran.telegram.bots.api.model.dto

data class GiveawayCompletedApi(
    val winnerCount: Int,
    val unclaimedPrizeCount: Int?,
    val giveawayMessage: MessageApi?,
) : ApiGodDto<GiveawayCompleted> {
    override fun typify() = GiveawayCompleted(
        winnerCount = winnerCount,
        unclaimedPrizeCount = unclaimedPrizeCount,
        giveawayMessage = giveawayMessage?.typify(),
    )
}

data class GiveawayCompleted(
    val winnerCount: Int,
    val unclaimedPrizeCount: Int?,
    val giveawayMessage: Message?,
)
