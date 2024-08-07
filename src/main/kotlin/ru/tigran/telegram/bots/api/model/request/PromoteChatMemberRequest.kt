package ru.tigran.telegram.bots.api.model.request

import ru.tigran.telegram.bots.api.model.TelegramRequest

data class PromoteChatMemberRequest(
    val chatId: String,
    val userId: Long,
    val isAnonymous: Boolean? = null,
    val canManageChat: Boolean? = null,
    val canDeleteMessages: Boolean? = null,
    val canManageVideoChats: Boolean? = null,
    val canRestrictMembers: Boolean? = null,
    val canPromoteMembers: Boolean? = null,
    val canChangeInfo: Boolean? = null,
    val canInviteUsers: Boolean? = null,
    val canPostStories: Boolean? = null,
    val canEditStories: Boolean? = null,
    val canDeleteStories: Boolean? = null,
    val canPostMessages: Boolean? = null,
    val canEditMessages: Boolean? = null,
    val canPinMessages: Boolean? = null,
    val canManageTopics: Boolean? = null,
) : TelegramRequest
