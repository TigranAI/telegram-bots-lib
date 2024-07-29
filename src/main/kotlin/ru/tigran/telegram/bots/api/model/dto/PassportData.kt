package ru.tigran.telegram.bots.api.model.dto

data class PassportData(
    val data: List<EncryptedPassportElement>,
    val credentials: EncryptedCredentials,
)
