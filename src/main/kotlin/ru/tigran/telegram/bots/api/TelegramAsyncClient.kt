package ru.tigran.telegram.bots.api

import org.springframework.stereotype.Service
import ru.tigran.telegram.bots.api.model.dto.Message
import ru.tigran.telegram.bots.api.model.dto.MessageId
import ru.tigran.telegram.bots.api.model.dto.Update
import ru.tigran.telegram.bots.api.model.dto.User
import ru.tigran.telegram.bots.api.model.request.*
import ru.tigran.telegram.bots.util.buildRequestBody

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
        api.getUpdates(buildRequestBody(request)).unwrap().map { it.typify() }

    suspend fun sendMessage(message: SendMessageRequest): Message =
        api.sendMessage(buildRequestBody(message)).unwrap().typify()

    suspend fun forwardMessage(message: ForwardMessageRequest): Message =
        api.forwardMessage(buildRequestBody(message)).unwrap().typify()

    suspend fun forwardMessages(messages: ForwardMessagesRequest): List<MessageId> =
        api.forwardMessages(buildRequestBody(messages)).unwrap()

    suspend fun copyMessage(message: CopyMessageRequest): MessageId =
        api.copyMessage(buildRequestBody(message)).unwrap()

    suspend fun copyMessages(messages: CopyMessagesRequest): List<MessageId> =
        api.copyMessages(buildRequestBody(messages)).unwrap()

    suspend fun sendPhoto(photo: SendPhotoRequest): Message =
        api.sendPhoto(buildRequestBody(photo)).unwrap().typify()

    suspend fun sendAudio(audio: SendAudioRequest): Message =
        api.sendAudio(buildRequestBody(audio)).unwrap().typify()

    suspend fun sendDocument(document: SendDocumentRequest): Message =
        api.sendDocument(buildRequestBody(document)).unwrap().typify()

    suspend fun sendVideo(video: SendVideoRequest): Message =
        api.sendVideo(buildRequestBody(video)).unwrap().typify()

    suspend fun sendAnimation(animation: SendAnimationRequest): Message =
        api.sendAnimation(buildRequestBody(animation)).unwrap().typify()

    suspend fun sendVoice(voice: SendVoiceRequest): Message =
        api.sendVoice(buildRequestBody(voice)).unwrap().typify()

    suspend fun sendVideoNote(videoNote: SendVideoNoteRequest): Message =
        api.sendVideoNote(buildRequestBody(videoNote)).unwrap().typify()

    suspend fun sendPaidMedia(paidMedia: SendPaidMediaRequest): Message =
        api.sendPaidMedia(buildRequestBody(paidMedia)).unwrap().typify()

    suspend fun sendMediaGroup(mediaGroup: SendMediaGroupRequest): List<Message> =
        api.sendMediaGroup(buildRequestBody(mediaGroup)).unwrap().map { it.typify() }

    suspend fun sendLocation(location: SendLocationRequest): Message =
        api.sendLocation(buildRequestBody(location)).unwrap().typify()

    suspend fun sendVenue(venue: SendVenueRequest): Message =
        api.sendVenue(buildRequestBody(venue)).unwrap().typify()

    suspend fun sendContact(contact: SendContactRequest): Message =
        api.sendContact(buildRequestBody(contact)).unwrap().typify()

    suspend fun sendPoll(poll: SendPollRequest): Message =
        api.sendPoll(buildRequestBody(poll)).unwrap().typify()

    suspend fun sendDice(dice: SendDiceRequest): Message =
        api.sendDice(buildRequestBody(dice)).unwrap().typify()

    suspend fun sendChatAction(chatAction: SendChatActionRequest): Boolean =
        api.sendChatAction(buildRequestBody(chatAction)).unwrap()

    suspend fun setMessageReaction(messageReaction: SetMessageReactionRequest): Boolean =
        api.setMessageReaction(buildRequestBody(messageReaction)).unwrap()
    
    suspend fun deleteMessages(messages: DeleteMessagesRequest): Boolean =
        api.deleteMessages(buildRequestBody(messages)).unwrap()
}