package ru.tigran.telegram.bots.util

import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import ru.tigran.telegram.bots.api.model.TelegramRequest
import ru.tigran.telegram.bots.api.model.dto.InputFile
import ru.tigran.telegram.bots.api.model.dto.InputMedia
import ru.tigran.telegram.bots.api.model.dto.InputPaidMedia
import ru.tigran.telegram.bots.api.model.dto.MultipartFile
import ru.tigran.telegram.bots.configuration.api.telegramApiCompatibleJacksonObjectMapper
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties

fun buildRequestBody(request: TelegramRequest): RequestBody {
    request.validate()

    val properties = request::class.memberProperties.associateWith { it.call(request) }
    return if (properties.any { hasMultipartFile(it.value) }) {
        buildMultipartBody(properties)
    } else {
        buildJsonBody(request)
    }
}

private fun buildMultipartBody(properties: Map<KProperty1<out TelegramRequest, *>, Any?>): RequestBody {
    val multipartBody = MultipartBody.Builder().setType(MultipartBody.FORM)
    properties.forEach { (prop, value) -> multipartBody.addAny(prop.name.toSnakeCase(), value) }
    return multipartBody.build()
}

private fun buildJsonBody(request: TelegramRequest): RequestBody = RequestBody.create(
    MediaType.parse("application/json"),
    telegramApiCompatibleJacksonObjectMapper.writeValueAsString(request),
)

private fun hasMultipartFile(value: Any?): Boolean {
    if (value is MultipartFile) {
        return value.hasFile()
    }
    if (value is List<*> && value.any { hasMultipartFile(it) }) {
        return true
    }
    return false
}

private fun MultipartBody.Builder.addAny(name: String, value: Any?) {
    when(value) {
        is String -> this.addFormDataPart(name, value)
        is InputFile -> this.addInputFile(name, value)
        is InputMedia -> this.addInputMedia(name, value)
        is InputPaidMedia -> this.addInputPaidMedia(name, value)
        is List<*> -> value.withIndex().forEach { (i, value) -> this.addAny("$name[$i]", value) }
        else -> value?.let {
            this.addFormDataPart(name, telegramApiCompatibleJacksonObjectMapper.writeValueAsString(it))
        }
    }
}

private fun MultipartBody.Builder.addInputFile(name: String, value: InputFile) {
    when(value) {
        is InputFile.InputFileMultipart -> {
            val fileBody = RequestBody.create(value.file.getMediaType(), value.file)
            this.addFormDataPart(name, value.file.name, fileBody)
        }
        is InputFile.InputFileId -> this.addFormDataPart(name, value.fileId)
        is InputFile.InputFileUrl -> this.addFormDataPart(name, value.url)
    }
}

private fun MultipartBody.Builder.addInputMedia(name: String, value: InputMedia) {
    if (!value.hasFile()) {
        this.addFormDataPart(name, telegramApiCompatibleJacksonObjectMapper.writeValueAsString(value))
        return
    }

    if (value.media is InputFile.InputFileMultipart) {
        val fileName = (value.media as InputFile.InputFileMultipart).file.name
        this.addInputFile(fileName, value.media)
    }
    if (value is InputMedia.InputMediaVideo && value.thumbnail is InputFile.InputFileMultipart){
        this.addInputFile(value.thumbnail.file.name, value.thumbnail)
    }
    if (value is InputMedia.InputMediaAudio && value.thumbnail is InputFile.InputFileMultipart){
        this.addInputFile(value.thumbnail.file.name, value.thumbnail)
    }
    if (value is InputMedia.InputMediaAnimation && value.thumbnail is InputFile.InputFileMultipart){
        this.addInputFile(value.thumbnail.file.name, value.thumbnail)
    }
    if (value is InputMedia.InputMediaDocument && value.thumbnail is InputFile.InputFileMultipart){
        this.addInputFile(value.thumbnail.file.name, value.thumbnail)
    }

    this.addFormDataPart(
        name,
        telegramApiCompatibleJacksonObjectMapper.writeValueAsString(value.convertToAttach())
    )
}

private fun MultipartBody.Builder.addInputPaidMedia(name: String, value: InputPaidMedia) {
    if (!value.hasFile()) {
        this.addFormDataPart(name, telegramApiCompatibleJacksonObjectMapper.writeValueAsString(value))
        return
    }

    if (value.media is InputFile.InputFileMultipart) {
        val fileName = (value.media as InputFile.InputFileMultipart).file.name
        this.addInputFile(fileName, value.media)
    }
    if (value is InputPaidMedia.InputPaidMediaVideo && value.thumbnail is InputFile.InputFileMultipart) {
        this.addInputFile(value.thumbnail.file.name, value.thumbnail)
    }

    this.addFormDataPart(
        name,
        telegramApiCompatibleJacksonObjectMapper.writeValueAsString(value.convertToAttach())
    )
}
