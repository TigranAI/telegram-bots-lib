package ru.tigran.telegram.bots.api.model.dto

data class PhotoSize(
    val fileId: String,
    val fileUniqueId: String,
    val width: Int,
    val height: Int,
    val fileSize: Long?,
)
