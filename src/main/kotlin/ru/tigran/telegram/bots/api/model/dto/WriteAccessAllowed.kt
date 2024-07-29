package ru.tigran.telegram.bots.api.model.dto

data class WriteAccessAllowed(
    val fromRequest: Boolean?,
    val webAppName: String?,
    val fromAttachmentMenu: Boolean?,
)
