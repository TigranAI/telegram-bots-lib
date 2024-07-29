package ru.tigran.telegram.bots.api.model

import ru.tigran.telegram.bots.api.model.exception.TelegramClientException

data class TelegramResponse<T>(
    val ok: Boolean,
    val result: T?,
    val errorCode: Int?,
    val description: String?,
) {
    fun unwrap(): T {
        if (ok) return result!!
        throw TelegramClientException(errorCode!!, description!!)
    }
}