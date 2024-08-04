package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest
import ru.tigran.telegram.bots.api.model.enums.UpdateType

data class GetUpdatesRequest(
    val offset: Long? = null,
    val limit: Int? = 100,
    val timeout: Int? = 1500,
    val allowedUpdates: List<UpdateType>? = null,
) : TelegramRequest
