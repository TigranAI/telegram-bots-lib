package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.enums.UpdateType

data class UpdateApi(
    val updateId: Long,
    val message: MessageApi?,
    val editedMessage: MessageApi?,
    val channelPost: MessageApi?,
    val editedChannelPost: MessageApi?,
    val businessConnection: BusinessConnection?,
    val businessMessage: MessageApi?,
    val editedBusinessMessage: MessageApi?,
    val deletedBusinessMessages: BusinessMessagesDeleted?,
    val messageReaction: MessageReactionUpdatedApi?,
    val messageReactionCount: MessageReactionCountUpdated?,
    val inlineQuery: InlineQuery?,
    val chosenInlineResult: ChosenInlineResult?,
    val callbackQuery: CallbackQuery?,
    val shippingQuery: ShippingQuery?,
    val preCheckoutQuery: PreCheckoutQuery?,
    val poll: Poll?,
    val pollAnswer: PollAnswer?,
    val myChatMember: ChatMemberUpdatedApi?,
    val chatMember: ChatMemberUpdatedApi?,
    val chatJoinRequest: ChatJoinRequest?,
    val chatBoost: ChatBoostUpdatedApi?,
    val removedChatBoost: ChatBoostRemoved?,
) : ApiGodDto<Update> {
    val type: UpdateType
        get() = when {
            message != null -> UpdateType.MESSAGE
            editedMessage != null -> UpdateType.EDITED_MESSAGE
            channelPost != null -> UpdateType.CHANNEL_POST
            editedChannelPost != null -> UpdateType.EDITED_CHANNEL_POST
            businessConnection != null -> UpdateType.BUSINESS_CONNECTION
            businessMessage != null -> UpdateType.BUSINESS_MESSAGE
            editedBusinessMessage != null -> UpdateType.EDITED_BUSINESS_MESSAGE
            deletedBusinessMessages != null -> UpdateType.DELETED_BUSINESS_MESSAGES
            messageReaction != null -> UpdateType.MESSAGE_REACTION
            messageReactionCount != null -> UpdateType.MESSAGE_REACTION_COUNT
            inlineQuery != null -> UpdateType.INLINE_QUERY
            chosenInlineResult != null -> UpdateType.CHOSEN_INLINE_RESULT
            callbackQuery != null -> UpdateType.CALLBACK_QUERY
            shippingQuery != null -> UpdateType.SHIPPING_QUERY
            preCheckoutQuery != null -> UpdateType.PRE_CHECKOUT_QUERY
            poll != null -> UpdateType.POLL
            pollAnswer != null -> UpdateType.POLL_ANSWER
            myChatMember != null -> UpdateType.MY_CHAT_MEMBER
            chatMember != null -> UpdateType.CHAT_MEMBER
            chatJoinRequest != null -> UpdateType.CHAT_JOIN_REQUEST
            chatBoost != null -> UpdateType.CHAT_BOOST
            removedChatBoost != null -> UpdateType.REMOVED_CHAT_BOTS
            else -> UpdateType.UNKNOWN
        }
    
    override fun typify() = when(type) {
        UpdateType.MESSAGE -> Update.MessageUpdate(
            updateId = updateId,
            message = message!!.typify(),
        )
        UpdateType.EDITED_MESSAGE -> Update.EditedMessageUpdate(
            updateId = updateId,
            editedMessage = editedMessage!!.typify(),
        )
        UpdateType.CHANNEL_POST -> Update.ChannelPostUpdate(
            updateId = updateId,
            channelPost = channelPost!!.typify(),
        )
        UpdateType.EDITED_CHANNEL_POST -> Update.EditedChannelPostUpdate(
            updateId = updateId,
            editedChannelPost = editedChannelPost!!.typify(),
        )
        UpdateType.BUSINESS_CONNECTION -> Update.BusinessConnectionUpdate(
            updateId = updateId,
            businessConnection = businessConnection!!,
        )
        UpdateType.BUSINESS_MESSAGE -> Update.BusinessMessageUpdate(
            updateId = updateId,
            businessMessage = businessMessage!!.typify(),
        )
        UpdateType.EDITED_BUSINESS_MESSAGE -> Update.EditedBusinessMessageUpdate(
            updateId = updateId,
            editedBusinessMessage = editedBusinessMessage!!.typify(),
        )
        UpdateType.DELETED_BUSINESS_MESSAGES -> Update.DeletedBusinessMessagesUpdate(
            updateId = updateId,
            deletedBusinessMessages = deletedBusinessMessages!!,
        )
        UpdateType.MESSAGE_REACTION -> Update.MessageReactionUpdate(
            updateId = updateId,
            messageReaction = messageReaction!!.typify(),
        )
        UpdateType.MESSAGE_REACTION_COUNT -> Update.MessageReactionCountUpdate(
            updateId = updateId,
            messageReactionCount = messageReactionCount!!,
        )
        UpdateType.INLINE_QUERY -> Update.InlineQueryUpdate(
            updateId = updateId,
            inlineQuery = inlineQuery!!,
        )
        UpdateType.CHOSEN_INLINE_RESULT -> Update.ChosenInlineResultUpdate(
            updateId = updateId,
            chosenInlineResult = chosenInlineResult!!,
        )
        UpdateType.CALLBACK_QUERY -> Update.CallbackQueryUpdate(
            updateId = updateId,
            callbackQuery = callbackQuery!!,
        )
        UpdateType.SHIPPING_QUERY -> Update.ShippingQueryUpdate(
            updateId = updateId,
            shippingQuery = shippingQuery!!,
        )
        UpdateType.PRE_CHECKOUT_QUERY -> Update.PreCheckoutQueryUpdate(
            updateId = updateId,
            preCheckoutQuery = preCheckoutQuery!!,
        )
        UpdateType.POLL -> Update.PollUpdate(
            updateId = updateId,
            poll = poll!!,
        )
        UpdateType.POLL_ANSWER -> Update.PollAnswerUpdate(
            updateId = updateId,
            pollAnswer = pollAnswer!!,
        )
        UpdateType.MY_CHAT_MEMBER -> Update.MyChatMemberUpdate(
            updateId = updateId,
            myChatMember = myChatMember!!.typify(),
        )
        UpdateType.CHAT_MEMBER -> Update.ChatMemberUpdate(
            updateId = updateId,
            chatMember = chatMember!!.typify(),
        )
        UpdateType.CHAT_JOIN_REQUEST -> Update.ChatJoinRequestUpdate(
            updateId = updateId,
            chatJoinRequest = chatJoinRequest!!,
        )
        UpdateType.CHAT_BOOST -> Update.ChatBoostUpdate(
            updateId = updateId,
            chatBoost = chatBoost!!.typify(),
        )
        UpdateType.REMOVED_CHAT_BOTS -> Update.RemovedChatBoostUpdate(
            updateId = updateId,
            removedChatBoost = removedChatBoost!!,
        )
        UpdateType.UNKNOWN -> Update.UnknownUpdate(
            updateId = updateId,
        )
    }
}

interface Update {
    val updateId: Long

    data class MessageUpdate(
        override val updateId: Long,
        val message: Message,
    ) : Update

    data class EditedMessageUpdate(
        override val updateId: Long,
        val editedMessage: Message,
    ) : Update

    data class ChannelPostUpdate(
        override val updateId: Long,
        val channelPost: Message,
    ) : Update

    data class EditedChannelPostUpdate(
        override val updateId: Long,
        val editedChannelPost: Message,
    ) : Update

    data class BusinessConnectionUpdate(
        override val updateId: Long,
        val businessConnection: BusinessConnection,
    ) : Update

    data class BusinessMessageUpdate(
        override val updateId: Long,
        val businessMessage: Message,
    ) : Update

    data class EditedBusinessMessageUpdate(
        override val updateId: Long,
        val editedBusinessMessage: Message,
    ) : Update

    data class DeletedBusinessMessagesUpdate(
        override val updateId: Long,
        val deletedBusinessMessages: BusinessMessagesDeleted,
    ) : Update

    data class MessageReactionUpdate(
        override val updateId: Long,
        val messageReaction: MessageReactionUpdated,
    ) : Update

    data class MessageReactionCountUpdate(
        override val updateId: Long,
        val messageReactionCount: MessageReactionCountUpdated,
    ) : Update

    data class InlineQueryUpdate(
        override val updateId: Long,
        val inlineQuery: InlineQuery,
    ) : Update

    data class ChosenInlineResultUpdate(
        override val updateId: Long,
        val chosenInlineResult: ChosenInlineResult,
    ) : Update

    data class CallbackQueryUpdate(
        override val updateId: Long,
        val callbackQuery: CallbackQuery,
    ) : Update

    data class ShippingQueryUpdate(
        override val updateId: Long,
        val shippingQuery: ShippingQuery,
    ) : Update

    data class PreCheckoutQueryUpdate(
        override val updateId: Long,
        val preCheckoutQuery: PreCheckoutQuery,
    ) : Update

    data class PollUpdate(
        override val updateId: Long,
        val poll: Poll?,
    ) : Update

    data class PollAnswerUpdate(
        override val updateId: Long,
        val pollAnswer: PollAnswer,
    ) : Update

    data class MyChatMemberUpdate(
        override val updateId: Long,
        val myChatMember: ChatMemberUpdated,
    ) : Update

    data class ChatMemberUpdate(
        override val updateId: Long,
        val chatMember: ChatMemberUpdated,
    ) : Update

    data class ChatJoinRequestUpdate(
        override val updateId: Long,
        val chatJoinRequest: ChatJoinRequest,
    ) : Update

    data class ChatBoostUpdate(
        override val updateId: Long,
        val chatBoost: ChatBoostUpdated,
    ) : Update

    data class RemovedChatBoostUpdate(
        override val updateId: Long,
        val removedChatBoost: ChatBoostRemoved,
    ) : Update

    data class UnknownUpdate(
        override val updateId: Long,
    ) : Update
}