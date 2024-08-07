package ru.tigran.telegram.bots.api.model.dto

data class ChatPhoto(
    val smallFileId: String,
    val smallFileUniqueId: String,
    val bigFileId: String,
    val bigFileUniqueId: String,
)
