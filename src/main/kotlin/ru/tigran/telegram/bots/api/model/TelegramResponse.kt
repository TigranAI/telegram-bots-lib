package ru.tigran.telegram.bots.api.model

import com.fasterxml.jackson.core.type.TypeReference
import okhttp3.ResponseBody
import org.springframework.http.HttpStatus
import ru.tigran.telegram.bots.api.model.exception.TelegramException
import ru.tigran.telegram.bots.configuration.api.telegramApiCompatibleJacksonObjectMapper

data class TelegramResponse<T>(
    val ok: Boolean,
    val result: T?,
    val errorCode: Int?,
    val description: String?,
) {
    fun unwrap(): T {
        if (ok) return result!!
        throw TelegramException(HttpStatus.valueOf(errorCode!!), description!!)
    }

    companion object {
        fun parse(body: ResponseBody): TelegramResponse<Void> {
            val typeRef = object: TypeReference<TelegramResponse<Void>>() {}
            return telegramApiCompatibleJacksonObjectMapper.readValue(body.bytes(), typeRef)
        }
    }
}