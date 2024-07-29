package ru.tigran.telegram.bots.api.model.dto

data class PassportFile(
    val fileId: String,
    val fileUniqueId: String,
    val fileSize: Long,
    val fileDate: Long,
)
