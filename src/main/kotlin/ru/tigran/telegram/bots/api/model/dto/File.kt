package ru.tigran.telegram.bots.api.model.dto

data class File(
    val fileId: String,
    val fileUniqueId: String,
    val fileSize: Long?,
    val filePath: String?,
)
