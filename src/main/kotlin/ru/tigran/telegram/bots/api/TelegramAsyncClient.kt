package ru.tigran.telegram.bots.api

import org.springframework.stereotype.Service
import ru.tigran.telegram.bots.api.model.dto.*
import ru.tigran.telegram.bots.api.model.request.*
import ru.tigran.telegram.bots.util.TelegramRequestBodyBuilder

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
        api.getUpdates(TelegramRequestBodyBuilder(request).build()).unwrap().map { it.typify() }

    suspend fun sendMessage(message: SendMessageRequest): Message =
        api.sendMessage(TelegramRequestBodyBuilder(message).build()).unwrap().typify()

    suspend fun forwardMessage(message: ForwardMessageRequest): Message =
        api.forwardMessage(TelegramRequestBodyBuilder(message).build()).unwrap().typify()

    suspend fun forwardMessages(messages: ForwardMessagesRequest): List<MessageId> =
        api.forwardMessages(TelegramRequestBodyBuilder(messages).build()).unwrap()

    suspend fun copyMessage(message: CopyMessageRequest): MessageId =
        api.copyMessage(TelegramRequestBodyBuilder(message).build()).unwrap()

    suspend fun copyMessages(messages: CopyMessagesRequest): List<MessageId> =
        api.copyMessages(TelegramRequestBodyBuilder(messages).build()).unwrap()

    suspend fun sendPhoto(photo: SendPhotoRequest): Message =
        api.sendPhoto(TelegramRequestBodyBuilder(photo).build()).unwrap().typify()

    suspend fun sendAudio(audio: SendAudioRequest): Message =
        api.sendAudio(TelegramRequestBodyBuilder(audio).build()).unwrap().typify()

    suspend fun sendDocument(document: SendDocumentRequest): Message =
        api.sendDocument(TelegramRequestBodyBuilder(document).build()).unwrap().typify()

    suspend fun sendVideo(video: SendVideoRequest): Message =
        api.sendVideo(TelegramRequestBodyBuilder(video).build()).unwrap().typify()

    suspend fun sendAnimation(animation: SendAnimationRequest): Message =
        api.sendAnimation(TelegramRequestBodyBuilder(animation).build()).unwrap().typify()

    suspend fun sendVoice(voice: SendVoiceRequest): Message =
        api.sendVoice(TelegramRequestBodyBuilder(voice).build()).unwrap().typify()

    suspend fun sendVideoNote(videoNote: SendVideoNoteRequest): Message =
        api.sendVideoNote(TelegramRequestBodyBuilder(videoNote).build()).unwrap().typify()

    suspend fun sendPaidMedia(paidMedia: SendPaidMediaRequest): Message =
        api.sendPaidMedia(TelegramRequestBodyBuilder(paidMedia).build()).unwrap().typify()

    suspend fun sendMediaGroup(mediaGroup: SendMediaGroupRequest): List<Message> =
        api.sendMediaGroup(TelegramRequestBodyBuilder(mediaGroup).build()).unwrap().map { it.typify() }

    suspend fun sendLocation(location: SendLocationRequest): Message =
        api.sendLocation(TelegramRequestBodyBuilder(location).build()).unwrap().typify()

    suspend fun sendVenue(venue: SendVenueRequest): Message =
        api.sendVenue(TelegramRequestBodyBuilder(venue).build()).unwrap().typify()

    suspend fun sendContact(contact: SendContactRequest): Message =
        api.sendContact(TelegramRequestBodyBuilder(contact).build()).unwrap().typify()

    suspend fun sendPoll(poll: SendPollRequest): Message =
        api.sendPoll(TelegramRequestBodyBuilder(poll).build()).unwrap().typify()

    suspend fun sendDice(dice: SendDiceRequest): Message =
        api.sendDice(TelegramRequestBodyBuilder(dice).build()).unwrap().typify()

    suspend fun sendChatAction(chatAction: SendChatActionRequest): Boolean =
        api.sendChatAction(TelegramRequestBodyBuilder(chatAction).build()).unwrap()

    suspend fun setMessageReaction(messageReaction: SetMessageReactionRequest): Boolean =
        api.setMessageReaction(TelegramRequestBodyBuilder(messageReaction).build()).unwrap()
}