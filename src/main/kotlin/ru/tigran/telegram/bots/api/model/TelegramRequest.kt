package ru.tigran.telegram.bots.api.model

import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import ru.tigran.telegram.bots.api.model.dto.InputFile
import ru.tigran.telegram.bots.configuration.api.telegramApiCompatibleJacksonObjectMapper
import ru.tigran.telegram.bots.util.addFormDataAnyPart
import ru.tigran.telegram.bots.util.toSnakeCase
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties

interface TelegramRequest {
    fun validate() {

    }

    fun asRequestBody(): RequestBody {
        validate()

        val properties = this::class.memberProperties.associateWith { it.call(this) }
        return if (properties.any { it.value is InputFile.InputFileMultipart }) {
            buildMultipartBody(properties)
        } else {
            buildJsonBody()
        }
    }

    private fun buildMultipartBody(properties: Map<KProperty1<out TelegramRequest, *>, Any?>): RequestBody {
        val multipartBody = MultipartBody.Builder().setType(MultipartBody.FORM)
        properties.forEach { (prop, value) -> multipartBody.addFormDataAnyPart(prop.name.toSnakeCase(), value) }
        return multipartBody.build()
    }

    private fun buildJsonBody(): RequestBody = RequestBody.create(
        MediaType.parse("application/json"),
        telegramApiCompatibleJacksonObjectMapper.writeValueAsString(this),
    )
}
