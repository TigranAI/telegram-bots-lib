package ru.tigran.telegram.bots.api.model.dto

data class VideoNode(
    val fileId: String,
    val fileUniqueId: String,
    val length: Int,
    val duration: Int,
    val thumbnail: PhotoSize?,
    val fileSize: Long?,
)
