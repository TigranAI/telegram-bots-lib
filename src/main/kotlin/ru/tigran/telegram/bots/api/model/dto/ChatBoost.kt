package ru.tigran.telegram.bots.api.model.dto

data class ChatBoost(
    val boostId: String,
    val addDate: Long,
    val expirationDate: Long,
    val source: ChatBoostSourceUnsealed,
)
