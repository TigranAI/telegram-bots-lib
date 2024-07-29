package ru.tigran.telegram.bots.api.model.dto

data class Animation(
    val fileId: String,
    val fileUniqueId: String,
    val width: Int,
    val height: Int,
    val duration: Int,
    val thumbnail: PhotoSize?,
    val fileName: String?,
    val mimeType: String?,
    val fileSize: Long?,
)
