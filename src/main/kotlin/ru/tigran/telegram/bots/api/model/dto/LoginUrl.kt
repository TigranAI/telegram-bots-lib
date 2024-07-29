package ru.tigran.telegram.bots.api.model.dto

data class LoginUrl(
    val url: String,
    val forwardText: String?,
    val botUsername: String?,
    val requestWriteAccess: Boolean?,
)
