package ru.tigran.telegram.bots.api.model.dto

data class ChatBackgroundUnsealed(
    val type: BackgroundUnsealed,
) {
    fun sealed() = ChatBackground(
        type = type.sealed(),
    )
}

data class ChatBackground (
    val type: Background,
)
