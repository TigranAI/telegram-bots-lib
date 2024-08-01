package ru.tigran.telegram.bots.api

import org.springframework.stereotype.Service
import ru.tigran.telegram.bots.api.model.dto.*
import ru.tigran.telegram.bots.api.model.request.GetUpdatesRequest
import ru.tigran.telegram.bots.api.model.request.SendMessageRequest
import ru.tigran.telegram.bots.configuration.api.TelegramApiProperties

@Service
class TelegramAsyncClient(
    private val properties: TelegramApiProperties,
    private val api: TelegramBotApi,
) {
    suspend fun getMe(): User = api.getMe(properties.token).unwrap()

    suspend fun logOut(): Void = api.logOut(properties.token).unwrap()

    suspend fun close(): Void = api.close(properties.token).unwrap()

    suspend fun getUpdates(
        request: GetUpdatesRequest,
    ): List<Update> = api.getUpdates(properties.token, request.asRequestMap()).unwrap().map { it.typify() }

    suspend fun sendMessage(
        request: SendMessageRequest,
    ): Message = api.sendMessage(properties.token, request).unwrap().typify()
}