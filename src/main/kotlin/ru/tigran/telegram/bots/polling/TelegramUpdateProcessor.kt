package ru.tigran.telegram.bots.polling

import ru.tigran.telegram.bots.api.model.dto.UpdateUnsealed

interface TelegramUpdateProcessor {
    suspend fun process(update: UpdateUnsealed)
}