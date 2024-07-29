package ru.tigran.telegram.bots.api.model.dto

data class ChatInviteLink(
    val inviteLink: String,
    val creator: User,
    val createsJoinRequest: Boolean,
    val isPrimary: Boolean,
    val isRevoked: Boolean,
    val name: String?,
    val expireDate: Long?,
    val memberLimit: Int?,
    val pendingJoinRequestCount: Int?,
)
