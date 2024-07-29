package ru.tigran.telegram.bots.api.model.dto

data class ChatBoostRemoved(
    val chat: Chat,
    val boostId: String,
    val removeDate: Long,
    val source: ChatBoostSource,
)
