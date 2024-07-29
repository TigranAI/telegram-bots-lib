package ru.tigran.telegram.bots.api.model.dto

data class EncryptedCredentials(
    val data: String,
    val hash: String,
    val secret: String,
)
