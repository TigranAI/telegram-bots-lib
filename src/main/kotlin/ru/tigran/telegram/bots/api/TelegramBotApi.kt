package ru.tigran.telegram.bots.api

import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import ru.tigran.telegram.bots.api.model.TelegramResponse
import ru.tigran.telegram.bots.api.model.dto.MessageApi
import ru.tigran.telegram.bots.api.model.dto.MessageId
import ru.tigran.telegram.bots.api.model.dto.UpdateApi
import ru.tigran.telegram.bots.api.model.dto.User

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

    @POST("/deleteMessages")
    suspend fun deleteMessages(@Body messages: RequestBody): TelegramResponse<Boolean>

    @POST("/setMyCommands")
    suspend fun setMyCommands(@Body commands: RequestBody): TelegramResponse<Boolean>
}