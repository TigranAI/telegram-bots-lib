package ru.tigran.telegram.bots.api.model.dto

data class UsersShared(
    val requestId: Long,
    val users: List<SharedUser>,
)
