package ru.tigran.telegram.bots.configuration.api

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.cfg.EnumFeature
import com.fasterxml.jackson.module.kotlin.kotlinModule
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import ru.tigran.telegram.bots.api.TelegramBotApi
import ru.tigran.telegram.bots.util.TelegramBotsInterceptor
import ru.tigran.telegram.bots.util.TelegramCallAdapterFactory

@Configuration
@ComponentScan("ru.tigran.telegram.bots.api")
@EnableConfigurationProperties(TelegramApiProperties::class)
class TelegramApiConfiguration(
    private val properties: TelegramApiProperties,
) {
    @Bean
    fun telegramBotApi(
        properties: TelegramApiProperties,
    ): TelegramBotApi {
        val jackson = JacksonConverterFactory.create(telegramApiCompatibleJacksonObjectMapper)
        val client = OkHttpClient.Builder()
            .addInterceptor(TelegramBotsInterceptor(properties))
            .addInterceptor(HttpLoggingInterceptor().setLevel(properties.loggingLevel))
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(properties.host)
            .client(client)
            .addConverterFactory(jackson)
            .addCallAdapterFactory(TelegramCallAdapterFactory())
            .build()
        return retrofit.create(TelegramBotApi::class.java)
    }
}

internal val telegramApiCompatibleJacksonObjectMapper = Jackson2ObjectMapperBuilder.json()
    .modules(kotlinModule())
    .propertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
    .serializationInclusion(JsonInclude.Include.NON_NULL)
    .featuresToEnable(
        MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS,
        EnumFeature.WRITE_ENUMS_TO_LOWERCASE,
    )
    .featuresToDisable(
        DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
    )
    .build<ObjectMapper>()
