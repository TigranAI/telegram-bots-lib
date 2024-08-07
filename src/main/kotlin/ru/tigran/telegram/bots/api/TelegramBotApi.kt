package ru.tigran.telegram.bots.api

import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import ru.tigran.telegram.bots.api.model.TelegramResponse
import ru.tigran.telegram.bots.api.model.dto.*

interface TelegramBotApi {
    @GET("/getMe")
    suspend fun getMe(): TelegramResponse<User>

    @POST("/logOut")
    suspend fun logOut(): TelegramResponse<Void>

    @POST("/close")
    suspend fun close(): TelegramResponse<Void>

    @POST("/getUpdates")
    suspend fun getUpdates(@Body params: RequestBody): TelegramResponse<List<UpdateApi>>

    @POST("/sendMessage")
    suspend fun sendMessage(@Body message: RequestBody): TelegramResponse<MessageApi>

    @POST("/forwardMessage")
    suspend fun forwardMessage(@Body message: RequestBody): TelegramResponse<MessageApi>

    @POST("/forwardMessages")
    suspend fun forwardMessages(@Body messages: RequestBody): TelegramResponse<List<MessageId>>

    @POST("/copyMessage")
    suspend fun copyMessage(@Body message: RequestBody): TelegramResponse<MessageId>

    @POST("/copyMessages")
    suspend fun copyMessages(@Body message: RequestBody): TelegramResponse<List<MessageId>>

    @POST("/sendPhoto")
    suspend fun sendPhoto(@Body photo: RequestBody): TelegramResponse<MessageApi>

    @POST("/sendAudio")
    suspend fun sendAudio(@Body audio: RequestBody): TelegramResponse<MessageApi>

    @POST("/sendDocument")
    suspend fun sendDocument(@Body document: RequestBody): TelegramResponse<MessageApi>

    @POST("/sendVideo")
    suspend fun sendVideo(@Body video: RequestBody): TelegramResponse<MessageApi>

    @POST("/sendAnimation")
    suspend fun sendAnimation(@Body animation: RequestBody): TelegramResponse<MessageApi>

    @POST("/sendVoice")
    suspend fun sendVoice(@Body voice: RequestBody): TelegramResponse<MessageApi>

    @POST("/sendVideoNote")
    suspend fun sendVideoNote(@Body videoNote: RequestBody): TelegramResponse<MessageApi>

    @POST("/sendPaidMedia")
    suspend fun sendPaidMedia(@Body paidMedia: RequestBody): TelegramResponse<MessageApi>

    @POST("/sendMediaGroup")
    suspend fun sendMediaGroup(@Body mediaGroup: RequestBody): TelegramResponse<List<MessageApi>>

    @POST("/sendLocation")
    suspend fun sendLocation(@Body location: RequestBody): TelegramResponse<MessageApi>

    @POST("/sendVenue")
    suspend fun sendVenue(@Body venue: RequestBody): TelegramResponse<MessageApi>

    @POST("/sendContact")
    suspend fun sendContact(@Body contact: RequestBody): TelegramResponse<MessageApi>

    @POST("/sendPoll")
    suspend fun sendPoll(@Body poll: RequestBody): TelegramResponse<MessageApi>

    @POST("/sendDice")
    suspend fun sendDice(@Body dice: RequestBody): TelegramResponse<MessageApi>

    @POST("/sendChatAction")
    suspend fun sendChatAction(@Body chatAction: RequestBody): TelegramResponse<Boolean>

    @POST("/setMessageReaction")
    suspend fun setMessageReaction(@Body messageReaction: RequestBody): TelegramResponse<Boolean>

    @POST("/getUserProfilePhotos")
    suspend fun getUserProfilePhotos(@Body photos: RequestBody): TelegramResponse<UserProfilePhotos>

    @GET("/getFile")
    suspend fun getFile(@Query("file_id") fileId: String): TelegramResponse<File>

    @GET("/{filePath}")
    suspend fun downloadFile(@Path("filePath") filePath: String): ByteArray

    @POST("/banChatMember")
    suspend fun banChatMember(@Body chatMember: RequestBody): TelegramResponse<Boolean>

    @POST("/unbanChatMember")
    suspend fun unbanChatMember(@Body chatMember: RequestBody): TelegramResponse<Boolean>

    @POST("/restrictChatMember")
    suspend fun restrictChatMember(@Body chatMember: RequestBody): TelegramResponse<Boolean>

    @POST("/promoteChatMember")
    suspend fun promoteChatMember(@Body chatMember: RequestBody): TelegramResponse<Boolean>

    @POST("/setChatAdministratorCustomTitle")
    suspend fun setChatAdministratorCustomTitle(@Body administrator: RequestBody): TelegramResponse<Boolean>

    @POST("/banChatSenderChat")
    suspend fun banChatSenderChat(@Body senderChat: RequestBody): TelegramResponse<Boolean>

    @POST("/unbanChatSenderChat")
    suspend fun unbanChatSenderChat(@Body senderChat: RequestBody): TelegramResponse<Boolean>

    @POST("/setChatPermissions")
    suspend fun setChatPermissions(@Body chatPermissions: RequestBody): TelegramResponse<Boolean>

    @POST("/exportChatInviteLink")
    suspend fun exportChatInviteLink(@Body inviteLink: RequestBody): TelegramResponse<String>

    @POST("/createChatInviteLink")
    suspend fun createChatInviteLink(@Body inviteLink: RequestBody): TelegramResponse<ChatInviteLink>

    @POST("/editChatInviteLink")
    suspend fun editChatInviteLink(@Body inviteLink: RequestBody): TelegramResponse<ChatInviteLink>

    @POST("/revokeChatInviteLink")
    suspend fun revokeChatInviteLink(@Body inviteLink: RequestBody): TelegramResponse<ChatInviteLink>

    @POST("/approveChatJoinRequest")
    suspend fun approveChatJoinRequest(@Body joinRequest: RequestBody): TelegramResponse<Boolean>

    @POST("/declineChatJoinRequest")
    suspend fun declineChatJoinRequest(@Body joinRequest: RequestBody): TelegramResponse<Boolean>

    @POST("/setChatPhoto")
    suspend fun setChatPhoto(@Body chatPhoto: RequestBody): TelegramResponse<Boolean>

    @POST("/deleteChatPhoto")
    suspend fun deleteChatPhoto(@Body chatPhoto: RequestBody): TelegramResponse<Boolean>

    @POST("/setChatTitle")
    suspend fun setChatTitle(@Body chatTitle: RequestBody): TelegramResponse<Boolean>

    @POST("/setChatDescription")
    suspend fun setChatDescription(@Body chatDescription: RequestBody): TelegramResponse<Boolean>

    @POST("/pinChatMessage")
    suspend fun pinChatMessage(@Body chatMessage: RequestBody): TelegramResponse<Boolean>

    @POST("/unpinChatMessage")
    suspend fun unpinChatMessage(@Body chatMessage: RequestBody): TelegramResponse<Boolean>

    @POST("/unpinAllChatMessages")
    suspend fun unpinAllChatMessages(@Body chatMessages: RequestBody): TelegramResponse<Boolean>

    @POST("/leaveChat")
    suspend fun leaveChat(@Body chat: RequestBody): TelegramResponse<Boolean>

    @GET("/getChat")
    suspend fun getChat(@Query("chat_id") chatId: String): TelegramResponse<ChatFullInfoApi>

    @GET("/getChatAdministrators")
    suspend fun getChatAdministrators(@Query("chat_id") chatId: String): TelegramResponse<List<ChatMemberApi>>

    @GET("/getChatMemberCount")
    suspend fun getChatMemberCount(@Query("chat_id") chatId: String): TelegramResponse<Int>

    @GET("/getChatMember")
    suspend fun getChatMember(
        @Query("chat_id") chatId: String,
        @Query("user_id") userId: Long,
    ): TelegramResponse<ChatMemberApi>

    @POST("/deleteMessages")
    suspend fun deleteMessages(@Body messages: RequestBody): TelegramResponse<Boolean>

    @POST("/setMyCommands")
    suspend fun setMyCommands(@Body commands: RequestBody): TelegramResponse<Boolean>
}