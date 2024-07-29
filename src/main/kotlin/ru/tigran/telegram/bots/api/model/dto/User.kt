package ru.tigran.telegram.bots.api.model.dto

data class User(
    val id: Long,
    val isBot: Boolean,
    val firstName: String,
    val lastname: String?,
    val username: String?,
    val languageCode: String?,
    val isPremium: Boolean?,
    val addedToAttachmentMenu: Boolean?,
    val canJoinGroups: Boolean?,
    val canReadAllGroupsMessages: Boolean?,
    val supportsInlineQueries: Boolean?,
    val canConnectToBusiness: Boolean?,
)
