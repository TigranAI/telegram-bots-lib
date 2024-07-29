package ru.tigran.telegram.bots.polling

import ru.tigran.telegram.bots.api.model.dto.Update

interface TelegramUpdateProcessor {
    suspend fun process(update: Update)
}