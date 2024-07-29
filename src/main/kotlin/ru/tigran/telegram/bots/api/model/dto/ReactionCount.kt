package ru.tigran.telegram.bots.api.model.dto

data class ReactionCount(
    val type: Reaction,
    val totalCount: Int,
)
