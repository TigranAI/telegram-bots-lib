package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.ApiGodDto

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
