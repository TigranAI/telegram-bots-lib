package ru.tigran.telegram.bots.util

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response
import ru.tigran.telegram.bots.configuration.api.TelegramApiProperties

class TelegramBotsInterceptor(
    private val properties: TelegramApiProperties,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val modifiedUrl = HttpUrl.Builder()
            .scheme(request.url().scheme())
            .host(request.url().host())
            .addPathSegment("bot${properties.token}")
            .addPathSegments(request.url().encodedPath().replaceFirstChar { "" })
            .build()
        return chain.proceed(request.newBuilder().url(modifiedUrl).build())
    }
}