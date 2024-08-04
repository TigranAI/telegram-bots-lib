package ru.tigran.telegram.bots.util

import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.springframework.http.MediaTypeFactory
import org.springframework.util.MimeType
import ru.tigran.telegram.bots.api.model.dto.InputFile
import ru.tigran.telegram.bots.configuration.api.telegramApiCompatibleJacksonObjectMapper
import java.io.File
import java.util.*
import kotlin.reflect.KClass
import kotlin.reflect.KProperty
import kotlin.reflect.full.isSubclassOf
import kotlin.reflect.jvm.jvmErasure

fun <K, V> mapOfNotNullValues(vararg pairs: Pair<K, V?>): Map<K, V> = pairs.asSequence()
    .filter { it.second != null }
    .map { it.first to it.second!! }
    .toMap()

fun anyNotNull(vararg objects: Any?) = objects.filterNotNull().isNotEmpty()

fun <T> Optional<T>.unwrap(): T? = orElse(null)

fun File.getMediaType(
    fallback: MimeType = MimeType.valueOf("image/*"),
) = (MediaTypeFactory.getMediaType(name).unwrap() ?: fallback).let { MediaType.parse(it.toString()) }

inline fun <reified T> KProperty<T>.isSubclassOf(kClass: KClass<*>) =
    this.getter.returnType.jvmErasure.isSubclassOf(kClass)

private val humps = "(?<=.)(?=\\p{Upper})".toRegex()
fun String.toSnakeCase() = replace(humps, "_").lowercase()

fun MultipartBody.Builder.addFormDataAnyPart(name: String, value: Any?) {
    when(value) {
        is String -> this.addFormDataPart(name, value)
        is InputFile.InputFileMultipart -> this.addFormDataPart(name, value.file.name, RequestBody.create(
            value.file.getMediaType(), value.file
        ))
        is InputFile.InputFileId -> this.addFormDataPart(name, value.fileId)
        is InputFile.InputFileUrl -> this.addFormDataPart(name, value.url)
        else -> value?.let {
            this.addFormDataPart(name, telegramApiCompatibleJacksonObjectMapper.writeValueAsString(it))
        }
    }
}
