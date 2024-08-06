package ru.tigran.telegram.bots.util

import okhttp3.MediaType
import org.springframework.http.MediaTypeFactory
import org.springframework.util.MimeType
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

inline fun <reified T> Any?.tryCast(default: T? = null): T? =
    if (this is T) this else default
