package ru.tigran.telegram.bots.api

import org.springframework.stereotype.Service
import ru.tigran.telegram.bots.api.model.dto.*
import ru.tigran.telegram.bots.api.model.request.*

@Service
class TelegramAsyncClient(
    private val api: TelegramBotApi,
) {
    suspend fun getMe(): User =
        api.getMe().unwrap()

    suspend fun logOut(): Void =
        api.logOut().unwrap()

    suspend fun close(): Void =
        api.close().unwrap()

    suspend fun getUpdates(request: GetUpdatesRequest): List<Update> =
        api.getUpdates(request.asRequestBody()).unwrap().map { it.typify() }

    suspend fun sendMessage(message: SendMessageRequest): Message =
        api.sendMessage(message.asRequestBody()).unwrap().typify()

    suspend fun forwardMessage(message: ForwardMessageRequest): Message =
        api.forwardMessage(message.asRequestBody()).unwrap().typify()

    suspend fun forwardMessages(messages: ForwardMessagesRequest): List<MessageId> =
        api.forwardMessages(messages.asRequestBody()).unwrap()

    suspend fun copyMessage(message: CopyMessageRequest): MessageId =
        api.copyMessage(message.asRequestBody()).unwrap()

    suspend fun copyMessages(messages: CopyMessagesRequest): List<MessageId> =
        api.copyMessages(messages.asRequestBody()).unwrap()

    suspend fun sendPhoto(photo: SendPhotoRequest): Message =
        api.sendPhoto(photo.asRequestBody()).unwrap().typify()

    suspend fun sendAudio(audio: SendAudioRequest): Message =
        api.sendAudio(audio.asRequestBody()).unwrap().typify()
}