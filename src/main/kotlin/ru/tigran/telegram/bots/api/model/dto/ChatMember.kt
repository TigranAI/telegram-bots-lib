package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.ApiGodDto
import ru.tigran.telegram.bots.api.model.enums.ChatMemberType

data class ChatMemberApi(
    val status: ChatMemberType,
    val user: User,
    val isAnonymous: Boolean?,
    val customTitle: String?,
    val canBeEdited: Boolean?,
    val canManageChat: Boolean?,
    val canDeleteMessages: Boolean?,
    val canManageVideoChats: Boolean?,
    val canRestrictMembers: Boolean?,
    val canPromoteMembers: Boolean?,
    val canChangeInfo: Boolean?,
    val canInviteUsers: Boolean?,
    val canPostStories: Boolean?,
    val canEditStories: Boolean?,
    val canDeleteStories: Boolean?,
    val canPostMessages: Boolean?,
    val canEditMessages: Boolean?,
    val canPinMessages: Boolean?,
    val canManageTopics: Boolean?,
    val isMember: Boolean?,
    val canSendMessages: Boolean?,
    val canSendAudios: Boolean?,
    val canSendDocuments: Boolean?,
    val canSendPhotos: Boolean?,
    val canSendVideos: Boolean?,
    val canSendVideoNotes: Boolean?,
    val canSendVoiceNotes: Boolean?,
    val canSendPolls: Boolean?,
    val canSendOtherMessages: Boolean?,
    val canAddWebPagePreviews: Boolean?,
    val untilDate: Long?,
) : ApiGodDto<ChatMember> {
    override fun typify() = when(status) {
        ChatMemberType.CREATOR -> ChatMember.ChatMemberOwner(
            status = status,
            user = user,
            isAnonymous = isAnonymous!!,
            customTitle = customTitle,
        )
        ChatMemberType.ADMINISTRATOR -> ChatMember.ChatMemberAdministrator(
            status = status,
            user = user,
            customTitle = customTitle,
            isAnonymous = isAnonymous!!,
            canBeEdited = canBeEdited!!,
            canManageChat = canManageChat!!,
            canDeleteMessages = canDeleteMessages!!,
            canManageVideoChats = canManageVideoChats!!,
            canRestrictMembers = canRestrictMembers!!,
            canPromoteMembers = canPromoteMembers!!,
            canChangeInfo = canChangeInfo!!,
            canInviteUsers = canInviteUsers!!,
            canPostStories = canPostStories!!,
            canEditStories = canEditStories!!,
            canDeleteStories = canDeleteStories!!,
            canPostMessages = canPostMessages,
            canEditMessages = canEditMessages,
            canPinMessages = canPinMessages,
            canManageTopics = canManageTopics,
        )
        ChatMemberType.MEMBER -> ChatMember.ChatMemberMember(
            status = status,
            user = user,
        )
        ChatMemberType.RESTRICTED -> ChatMember.ChatMemberRestricted(
            status = status,
            user = user,
            isMember = isMember!!,
            canSendMessages = canSendMessages!!,
            canSendAudios = canSendAudios!!,
            canSendDocuments = canSendDocuments!!,
            canSendPhotos = canSendPhotos!!,
            canSendVideos = canSendVideos!!,
            canSendVideoNotes = canSendVideoNotes!!,
            canSendVoiceNotes = canSendVoiceNotes!!,
            canSendPolls = canSendPolls!!,
            canSendOtherMessages = canSendOtherMessages!!,
            canAddWebPagePreviews = canAddWebPagePreviews!!,
            canChangeInfo = canChangeInfo!!,
            canInviteUsers = canInviteUsers!!,
            canPinMessages = canPinMessages!!,
            canManageTopics = canManageTopics!!,
            untilDate = untilDate!!,
        )
        ChatMemberType.LEFT -> ChatMember.ChatMemberLeft(
            status = status,
            user = user,
        )
        ChatMemberType.KICKED -> ChatMember.ChatMemberBanned(
            status = status,
            user = user,
            untilDate = untilDate!!,
        )
    }
}

interface ChatMember {
    val status: ChatMemberType
    val user: User

    data class ChatMemberOwner(
        override val status: ChatMemberType,
        override val user: User,
        val isAnonymous: Boolean,
        val customTitle: String?,
    ) : ChatMember

    data class ChatMemberAdministrator(
        override val status: ChatMemberType,
        override val user: User,
        val customTitle: String?,
        val isAnonymous: Boolean,
        val canBeEdited: Boolean,
        val canManageChat: Boolean,
        val canDeleteMessages: Boolean,
        val canManageVideoChats: Boolean,
        val canRestrictMembers: Boolean,
        val canPromoteMembers: Boolean,
        val canChangeInfo: Boolean,
        val canInviteUsers: Boolean,
        val canPostStories: Boolean,
        val canEditStories: Boolean,
        val canDeleteStories: Boolean,
        val canPostMessages: Boolean?,
        val canEditMessages: Boolean?,
        val canPinMessages: Boolean?,
        val canManageTopics: Boolean?,
    ) : ChatMember

    data class ChatMemberMember(
        override val status: ChatMemberType,
        override val user: User,
    ) : ChatMember

    data class ChatMemberRestricted(
        override val status: ChatMemberType,
        override val user: User,
        val isMember: Boolean,
        val canSendMessages: Boolean,
        val canSendAudios: Boolean,
        val canSendDocuments: Boolean,
        val canSendPhotos: Boolean,
        val canSendVideos: Boolean,
        val canSendVideoNotes: Boolean,
        val canSendVoiceNotes: Boolean,
        val canSendPolls: Boolean,
        val canSendOtherMessages: Boolean,
        val canAddWebPagePreviews: Boolean,
        val canChangeInfo: Boolean,
        val canInviteUsers: Boolean,
        val canPinMessages: Boolean,
        val canManageTopics: Boolean,
        val untilDate: Long,
    ) : ChatMember

    data class ChatMemberLeft(
        override val status: ChatMemberType,
        override val user: User,
    ) : ChatMember

    data class ChatMemberBanned(
        override val status: ChatMemberType,
        override val user: User,
        val untilDate: Long,
    ) : ChatMember
}