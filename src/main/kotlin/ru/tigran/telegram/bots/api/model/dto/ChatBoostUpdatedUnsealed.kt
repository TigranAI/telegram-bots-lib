package ru.tigran.telegram.bots.api.model.dto

data class ChatBoostUpdatedUnsealed(
    val chat: Chat,
    val boost: ChatBoostUnsealed,
) {
    fun sealed() = ChatBoostUpdated(
        chat = chat,
        boost = boost.sealed(),
    )
}

data class ChatBoostUpdated(
    val chat: Chat,
    val boost: ChatBoost,
)