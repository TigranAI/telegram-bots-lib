package ru.tigran.telegram.bots.api

import okhttp3.MultipartBody
import retrofit2.http.*
import ru.tigran.telegram.bots.api.model.TelegramResponse
import ru.tigran.telegram.bots.api.model.dto.MessageApi
import ru.tigran.telegram.bots.api.model.dto.MessageId
import ru.tigran.telegram.bots.api.model.dto.UpdateApi
import ru.tigran.telegram.bots.api.model.dto.User
import ru.tigran.telegram.bots.api.model.request.*

interface TelegramBotApi {
    @GET("/bot{token}/getMe")
    suspend fun getMe(
        @Path("token") token: String,
    ): TelegramResponse<User>

    @POST("/bot{token}/logOut")
    suspend fun logOut(
        @Path("token") token: String,
    ): TelegramResponse<Void>

    @POST("/bot{token}/close")
    suspend fun close(
        @Path("token") token: String,
    ): TelegramResponse<Void>

    @GET("/bot{token}/getUpdates")
    suspend fun getUpdates(
        @Path("token") token: String,
        @QueryMap params: Map<String, String>,
    ): TelegramResponse<List<UpdateApi>>

    @POST("/bot{token}/sendMessage")
    suspend fun sendMessage(
        @Path("token") token: String,
        @Body message: SendMessageRequest,
    ): TelegramResponse<MessageApi>

    @POST("/bot{token}/forwardMessage")
    suspend fun forwardMessage(
        @Path("token") token: String,
        @Body message: ForwardMessageRequest,
    ): TelegramResponse<MessageApi>

    @POST("/bot{token}/forwardMessages")
    suspend fun forwardMessages(
        @Path("token") token: String,
        @Body messages: ForwardMessagesRequest,
    ): TelegramResponse<List<MessageId>>

    @POST("/bot{token}/copyMessage")
    suspend fun copyMessage(
        @Path("token") token: String,
        @Body message: CopyMessageRequest,
    ): TelegramResponse<MessageId>

    @POST("/bot{token}/copyMessages")
    suspend fun copyMessages(
        @Path("token") token: String,
        @Body message: CopyMessagesRequest,
    ): TelegramResponse<List<MessageId>>

    @Multipart
    @POST("/bot{token}/sendPhoto")
    suspend fun sendPhoto(
        @Path("token") token: String,
        @Body photo: SendPhotoRequest,
        @Part photoMultipart: MultipartBody.Part?,
    ): TelegramResponse<MessageApi>

    @Multipart
    @POST("/bot{token}/sendAudio")
    suspend fun sendAudio(
        @Path("token") token: String,
        @Body audio: SendAudioRequest,
        @Part audioMultipart: MultipartBody.Part?,
        @Part thumbnailMultipart: MultipartBody.Part?,
    ): TelegramResponse<MessageApi>
}