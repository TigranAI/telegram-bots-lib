package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.ApiGodDto

data class ChatBoostApi(
    val boostId: String,
    val addDate: Long,
    val expirationDate: Long,
    val source: ChatBoostSourceApi,
) : ApiGodDto<ChatBoost> {
    override fun typify() = ChatBoost(
        boostId = boostId,
        addDate = addDate,
        expirationDate = expirationDate,
        source = source.typify(),
    )
}

data class ChatBoost(
    val boostId: String,
    val addDate: Long,
    val expirationDate: Long,
    val source: ChatBoostSource,
)