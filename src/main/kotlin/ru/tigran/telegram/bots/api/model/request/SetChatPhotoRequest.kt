package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest
import ru.tigran.telegram.bots.api.model.dto.InputFile

data class SetChatPhotoRequest(
    val chatId: String,
    val photo: InputFile.InputFileMultipart,
) : TelegramRequest
