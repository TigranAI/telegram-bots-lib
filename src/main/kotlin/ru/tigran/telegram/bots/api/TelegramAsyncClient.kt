package ru.tigran.telegram.bots.api

import org.springframework.stereotype.Service
import ru.tigran.telegram.bots.api.model.dto.*
import ru.tigran.telegram.bots.api.model.request.*
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
        message: SendMessageRequest,
    ): Message = api.sendMessage(properties.token, message).unwrap().typify()

    suspend fun forwardMessage(
        message: ForwardMessageRequest,
    ): Message = api.forwardMessage(properties.token, message).unwrap().typify()

    suspend fun forwardMessages(
        messages: ForwardMessagesRequest,
    ): List<MessageId> = api.forwardMessages(properties.token, messages).unwrap()

    suspend fun copyMessage(
        message: CopyMessageRequest,
    ): MessageId = api.copyMessage(properties.token, message).unwrap()

    suspend fun copyMessages(
        messages: CopyMessagesRequest,
    ): List<MessageId> = api.copyMessages(properties.token, messages).unwrap()

    suspend fun sendPhoto(
        photo: SendPhotoRequest,
    ): Message = api.sendPhoto(
        token = properties.token,
        photo = photo,
        photoMultipart = photo.photo.multipart("photo"),
    ).unwrap().typify()

    suspend fun sendAudio(
        audio: SendAudioRequest,
    ): Message = api.sendAudio(
        token = properties.token,
        audio = audio,
        audioMultipart = audio.audio.multipart("audio"),
        thumbnailMultipart = audio.thumbnail?.multipart("thumbnail"),
    ).unwrap().typify()
}