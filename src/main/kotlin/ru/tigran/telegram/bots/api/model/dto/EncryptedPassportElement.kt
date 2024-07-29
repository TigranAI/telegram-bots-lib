package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.enums.EncryptedPassportElementType

data class EncryptedPassportElement(
    val type: EncryptedPassportElementType,
    val data: String?,
    val phoneNumber: String?,
    val email: String?,
    val files: List<PassportFile>?,
    val frontSize: PassportFile?,
    val reverseSide: PassportFile?,
    val selfie: PassportFile?,
    val translation: List<PassportFile>?,
    val hash: String,
)
