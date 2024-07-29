package ru.tigran.telegram.bots.api.model.dto

data class PollAnswer(
    val pollId: String,
    val voterChat: Chat?,
    val user: User?,
    val optionIds: List<Int>,
)
