package ru.tigran.telegram.bots.api.model.dto

data class SwitchInlineQueryChosenChat(
    val query: String,
    val allowUserChats: Boolean?,
    val allowBotChats: Boolean?,
    val allowGroupChats: Boolean?,
    val allowChannelChats: Boolean?,
)
