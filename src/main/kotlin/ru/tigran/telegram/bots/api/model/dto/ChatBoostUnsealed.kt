package ru.tigran.telegram.bots.api.model.dto

data class ChatBoostUnsealed(
    val boostId: String,
    val addDate: Long,
    val expirationDate: Long,
    val source: ChatBoostSourceUnsealed,
) {
    fun sealed() = ChatBoost(
        boostId = boostId,
        addDate = addDate,
        expirationDate = expirationDate,
        source = source.sealed(),
    )
}

data class ChatBoost(
    val boostId: String,
    val addDate: Long,
    val expirationDate: Long,
    val source: ChatBoostSource,
)