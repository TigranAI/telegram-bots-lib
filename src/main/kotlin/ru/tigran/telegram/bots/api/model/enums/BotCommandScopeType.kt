package ru.tigran.telegram.bots.api.model.enums

enum class BotCommandScopeType {
    DEFAULT,
    ALL_PRIVATE_CHATS,
    ALL_GROUP_CHATS,
    ALL_CHAT_ADMINISTRATORS,
    CHAT,
    CHAT_ADMINISTRATORS,
    CHAT_MEMBER,
}