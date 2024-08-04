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
}