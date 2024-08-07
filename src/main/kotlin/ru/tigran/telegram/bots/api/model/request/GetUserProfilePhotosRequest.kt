package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest

data class GetUserProfilePhotosRequest(
    val userId: Long,
    val offset: Int?,
    val limit: Int?,
) : TelegramRequest
