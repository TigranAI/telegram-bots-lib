package ru.tigran.telegram.bots.api.model.dto

data class Contact(
    val phoneNumber: String,
    val firstName: String,
    val lastName: String?,
    val userId: Long?,
    val vcard: String?,
)
