package ru.tigran.telegram.bots.api.model.dto

data class Voice(
    val fileId: String,
    val fileUniqueId: String,
    val duration: Int,
    val mimeType: String?,
    val fileSize: Long?,
)
