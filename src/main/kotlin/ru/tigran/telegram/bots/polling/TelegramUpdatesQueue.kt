package ru.tigran.telegram.bots.polling

import ru.tigran.telegram.bots.api.model.dto.UpdateUnsealed

interface TelegramUpdatesQueue {
    fun enqueueAll(updates: List<UpdateUnsealed>)

    fun dequeueBatch(size: Int): List<UpdateUnsealed>
}