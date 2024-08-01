package ru.tigran.telegram.bots.api.model.dto

data class ChatBackgroundApi(
    val type: BackgroundApi,
) : ApiGodDto<ChatBackground> {
    override fun typify() = ChatBackground(
        type = type.typify(),
    )
}

data class ChatBackground (
    val type: Background,
)
