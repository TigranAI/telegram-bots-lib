package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.ApiGodDto

data class ChatBoostUpdatedApi(
    val chat: Chat,
    val boost: ChatBoostApi,
) : ApiGodDto<ChatBoostUpdated> {
    override fun typify() = ChatBoostUpdated(
        chat = chat,
        boost = boost.typify(),
    )
}

data class ChatBoostUpdated(
    val chat: Chat,
    val boost: ChatBoost,
)