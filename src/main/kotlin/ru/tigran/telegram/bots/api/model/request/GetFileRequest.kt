package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest

data class GetFileRequest(
    val fileId: String,
) : TelegramRequest
