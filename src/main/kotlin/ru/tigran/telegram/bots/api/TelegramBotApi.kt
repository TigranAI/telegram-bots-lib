package ru.tigran.telegram.bots.api

import retrofit2.http.*
import ru.tigran.telegram.bots.api.model.TelegramResponse
import ru.tigran.telegram.bots.api.model.dto.MessageApi
import ru.tigran.telegram.bots.api.model.dto.UpdateApi
import ru.tigran.telegram.bots.api.model.dto.User
import ru.tigran.telegram.bots.api.model.request.SendMessageRequest

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
}