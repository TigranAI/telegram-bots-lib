package ru.tigran.telegram.bots.api

import org.springframework.stereotype.Service
import ru.tigran.telegram.bots.api.model.dto.*
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

    suspend fun getUserProfilePhotos(userProfilePhotos: GetUserProfilePhotosRequest): UserProfilePhotos =
        api.getUserProfilePhotos(buildRequestBody(userProfilePhotos)).unwrap()

    suspend fun getFile(file: GetFileRequest): File =
        api.getFile(file.fileId).unwrap()

    suspend fun downloadFile(file: DownloadFileRequest): ByteArray =
        api.downloadFile(file.filePath)

    suspend fun banChatMember(chatMember: BanChatMemberRequest): Boolean =
        api.banChatMember(buildRequestBody(chatMember)).unwrap()

    suspend fun unbanChatMember(chatMember: UnbanChatMemberRequest): Boolean =
        api.unbanChatMember(buildRequestBody(chatMember)).unwrap()

    suspend fun restrictChatMember(chatMember: RestrictChatMemberRequest): Boolean =
        api.restrictChatMember(buildRequestBody(chatMember)).unwrap()

    suspend fun promoteChatMember(chatMember: PromoteChatMemberRequest): Boolean =
        api.promoteChatMember(buildRequestBody(chatMember)).unwrap()

    suspend fun setChatAdministratorCustomTitle(administrator: SetChatAdministratorCustomTitleRequest): Boolean =
        api.setChatAdministratorCustomTitle(buildRequestBody(administrator)).unwrap()

    suspend fun banChatSenderChat(senderChat: BanChatSenderChatRequest): Boolean =
        api.banChatSenderChat(buildRequestBody(senderChat)).unwrap()

    suspend fun unbanChatSenderChat(chatPermissions: SetChatPermissionsRequest): Boolean =
        api.unbanChatSenderChat(buildRequestBody(chatPermissions)).unwrap()

    suspend fun setChatPermissions(senderChat: UnbanChatSenderChatRequest): Boolean =
        api.setChatPermissions(buildRequestBody(senderChat)).unwrap()

    suspend fun exportChatInviteLink(inviteLink: ExportChatInviteLinkRequest): String =
        api.exportChatInviteLink(buildRequestBody(inviteLink)).unwrap()

    suspend fun createChatInviteLink(inviteLink: CreateChatInviteLinkRequest): ChatInviteLink =
        api.createChatInviteLink(buildRequestBody(inviteLink)).unwrap()

    suspend fun editChatInviteLink(inviteLink: EditChatInviteLinkRequest): ChatInviteLink =
        api.editChatInviteLink(buildRequestBody(inviteLink)).unwrap()

    suspend fun revokeChatInviteLink(inviteLink: RevokeChatInviteLinkRequest): ChatInviteLink =
        api.revokeChatInviteLink(buildRequestBody(inviteLink)).unwrap()

    suspend fun approveChatJoinRequest(joinRequest: ApproveChatJoinRequest): Boolean =
        api.approveChatJoinRequest(buildRequestBody(joinRequest)).unwrap()

    suspend fun declineChatJoinRequest(joinRequest: DeclineChatJoinRequest): Boolean =
        api.declineChatJoinRequest(buildRequestBody(joinRequest)).unwrap()

    suspend fun setChatPhoto(chatPhoto: SetChatPhotoRequest): Boolean =
        api.setChatPhoto(buildRequestBody(chatPhoto)).unwrap()

    suspend fun deleteChatPhoto(chatPhoto: DeleteChatPhotoRequest): Boolean =
        api.deleteChatPhoto(buildRequestBody(chatPhoto)).unwrap()

    suspend fun setChatTitle(chatTitle: SetChatTitleRequest): Boolean =
        api.setChatTitle(buildRequestBody(chatTitle)).unwrap()

    suspend fun setChatDescription(chatDescription: SetChatDescriptionRequest): Boolean =
        api.setChatDescription(buildRequestBody(chatDescription)).unwrap()

    suspend fun pinChatMessage(chatMessage: PinChatMessageRequest): Boolean =
        api.pinChatMessage(buildRequestBody(chatMessage)).unwrap()

    suspend fun unpinChatMessage(chatMessage: UnpinChatMessageRequest): Boolean =
        api.unpinChatMessage(buildRequestBody(chatMessage)).unwrap()

    suspend fun unpinAllChatMessages(chatMessages: UnpinAllChatMessagesRequest): Boolean =
        api.unpinAllChatMessages(buildRequestBody(chatMessages)).unwrap()

    suspend fun leaveChat(chat: LeaveChatRequest): Boolean =
        api.leaveChat(buildRequestBody(chat)).unwrap()

    suspend fun getChat(chat: GetChatRequest): ChatFullInfo =
        api.getChat(chat.chatId).unwrap().typify()

    suspend fun getChatAdministrators(chat: GetChatAdministratorsRequest): List<ChatMember> =
        api.getChatAdministrators(chat.chatId).unwrap().map { it.typify() }

    suspend fun getChatMemberCount(chat: GetChatMemberCountRequest): Int =
        api.getChatMemberCount(chat.chatId).unwrap()

    suspend fun getChatMember(chat: GetChatMemberRequest): ChatMember =
        api.getChatMember(chat.chatId, chat.userId).unwrap().typify()
    
    suspend fun deleteMessages(messages: DeleteMessagesRequest): Boolean =
        api.deleteMessages(buildRequestBody(messages)).unwrap()

    suspend fun setMyCommands(commands: SetMyCommandsRequest): Boolean =
        api.setMyCommands(buildRequestBody(commands)).unwrap()
}