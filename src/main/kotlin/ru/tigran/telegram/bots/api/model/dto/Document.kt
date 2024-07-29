package ru.tigran.telegram.bots.api.model.dto

data class Document(
    val fileId: String,
    val fileUniqueId: String,
    val thumbnail: PhotoSize?,
    val fileName: String?,
    val mimeType: String?,
    val fileSize: Long?,
)
