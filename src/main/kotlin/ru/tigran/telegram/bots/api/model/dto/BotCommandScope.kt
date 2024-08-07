package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.enums.BotCommandScopeType

interface BotCommandScope {
    val type: BotCommandScopeType

    class BotCommandScopeDefault : BotCommandScope {
        override val type: BotCommandScopeType = BotCommandScopeType.DEFAULT

        override fun toString(): String {
            return "BotCommandScopeDefault(type=$type)"
        }
    }

    class BotCommandScopeAllPrivateChats : BotCommandScope {
        override val type: BotCommandScopeType = BotCommandScopeType.ALL_PRIVATE_CHATS

        override fun toString(): String {
            return "BotCommandScopeAllPrivateChats(type=$type)"
        }
    }

    class BotCommandScopeAllGroupChats : BotCommandScope {
        override val type: BotCommandScopeType = BotCommandScopeType.ALL_GROUP_CHATS

        override fun toString(): String {
            return "BotCommandScopeAllGroupChats(type=$type)"
        }
    }

    class BotCommandScopeAllChatAdministrators : BotCommandScope {
        override val type: BotCommandScopeType = BotCommandScopeType.ALL_CHAT_ADMINISTRATORS

        override fun toString(): String {
            return "BotCommandScopeAllChatAdministrators(type=$type)"
        }
    }

    data class BotCommandScopeChat(
        val chatId: String,
    ) : BotCommandScope {
        override val type: BotCommandScopeType = BotCommandScopeType.CHAT
    }

    data class BotCommandScopeChatAdministrators(
        val chatId: String,
    ) : BotCommandScope {
        override val type: BotCommandScopeType = BotCommandScopeType.CHAT_ADMINISTRATORS
    }

    data class BotCommandScopeChatMember(
        val chatId: String,
        val userId: Long,
    ) : BotCommandScope {
        override val type: BotCommandScopeType = BotCommandScopeType.CHAT_MEMBER
    }
}
