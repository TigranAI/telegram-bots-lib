package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.enums.UpdateType
import ru.tigran.telegram.bots.util.mapOfNotNullValues

data class GetUpdatesRequest(
    val offset: Long? = null,
    val limit: Int? = 100,
    val timeout: Int? = 1500,
    val allowedUpdates: List<UpdateType>? = null,
) {
    fun asRequestMap() = mapOfNotNullValues(
        "offset" to offset?.toString(),
        "limit" to limit?.toString(),
        "timeout" to timeout?.toString(),
        "allowed_updates" to allowedUpdates?.joinToString(",") { it.name.lowercase() },
    )
}