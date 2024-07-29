package ru.tigran.telegram.bots.polling

import ru.tigran.telegram.bots.api.model.dto.Update

interface TelegramUpdatesQueue {
    fun enqueueAll(updates: List<Update>)

    fun dequeueBatch(size: Int): List<Update>
}