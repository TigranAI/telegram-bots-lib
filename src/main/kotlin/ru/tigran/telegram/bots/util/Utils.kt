package ru.tigran.telegram.bots.util

import org.springframework.http.MediaTypeFactory
import org.springframework.util.MimeType
import java.io.File
import java.util.*

fun <K, V> mapOfNotNullValues(vararg pairs: Pair<K, V?>): Map<K, V> = pairs.asSequence()
    .filter { it.second != null }
    .map { it.first to it.second!! }
    .toMap()

fun anyNotNull(vararg objects: Any?) = objects.filterNotNull().isNotEmpty()

fun <T> Optional<T>.unwrap(): T? = orElse(null)

fun File.getMimeType(
    fallback: MimeType = MimeType.valueOf("image/*"),
) = MediaTypeFactory.getMediaType(name).unwrap() ?: fallback