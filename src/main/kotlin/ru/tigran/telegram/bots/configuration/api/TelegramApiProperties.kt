package ru.tigran.telegram.bots.configuration.api

import okhttp3.logging.HttpLoggingInterceptor.Level
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "telegram.api")
data class TelegramApiProperties (
    val host: String,
    val token: String,
    val loggingLevel: Level = Level.NONE,
)