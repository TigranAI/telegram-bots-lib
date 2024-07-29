package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.enums.UpdateType

data class UpdateUnsealed(
    val updateId: Long,
    val message: MessageUnsealed?,
    val editedMessage: MessageUnsealed?,
    val channelPost: MessageUnsealed?,
    val editedChannelPost: MessageUnsealed?,
    val businessConnection: BusinessConnection?,
    val businessMessage: MessageUnsealed?,
    val editedBusinessMessage: MessageUnsealed?,
    val deletedBusinessMessages: BusinessMessagesDeleted?,
    val messageReaction: MessageReactionUpdatedUnsealed?,
    val messageReactionCount: MessageReactionCountUpdated?,
    val inlineQuery: InlineQuery?,
    val chosenInlineResult: ChosenInlineResult?,
    val callbackQuery: CallbackQuery?,
    val shippingQuery: ShippingQuery?,
    val preCheckoutQuery: PreCheckoutQuery?,
    val poll: Poll?,
    val pollAnswer: PollAnswer?,
    val myChatMember: ChatMemberUpdatedUnsealed?,
    val chatMember: ChatMemberUpdatedUnsealed?,
    val chatJoinRequest: ChatJoinRequest?,
    val chatBoost: ChatBoostUpdatedUnsealed?,
    val removedChatBoost: ChatBoostRemoved?,
) {
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
    
    fun sealed() = when(type) {
        UpdateType.MESSAGE -> Update.MessageUpdate(
            updateId = updateId,
            message = message!!.sealed(),
        )
        UpdateType.EDITED_MESSAGE -> Update.EditedMessageUpdate(
            updateId = updateId,
            editedMessage = editedMessage!!.sealed(),
        )
        UpdateType.CHANNEL_POST -> Update.ChannelPostUpdate(
            updateId = updateId,
            channelPost = channelPost!!.sealed(),
        )
        UpdateType.EDITED_CHANNEL_POST -> Update.EditedChannelPostUpdate(
            updateId = updateId,
            editedChannelPost = editedChannelPost!!.sealed(),
        )
        UpdateType.BUSINESS_CONNECTION -> Update.BusinessConnectionUpdate(
            updateId = updateId,
            businessConnection = businessConnection!!,
        )
        UpdateType.BUSINESS_MESSAGE -> Update.BusinessMessageUpdate(
            updateId = updateId,
            businessMessage = businessMessage!!.sealed(),
        )
        UpdateType.EDITED_BUSINESS_MESSAGE -> Update.EditedBusinessMessageUpdate(
            updateId = updateId,
            editedBusinessMessage = editedBusinessMessage!!.sealed(),
        )
        UpdateType.DELETED_BUSINESS_MESSAGES -> Update.DeletedBusinessMessagesUpdate(
            updateId = updateId,
            deletedBusinessMessages = deletedBusinessMessages!!,
        )
        UpdateType.MESSAGE_REACTION -> Update.MessageReactionUpdate(
            updateId = updateId,
            messageReaction = messageReaction!!.sealed(),
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
            myChatMember = myChatMember!!.sealed(),
        )
        UpdateType.CHAT_MEMBER -> Update.ChatMemberUpdate(
            updateId = updateId,
            chatMember = chatMember!!.sealed(),
        )
        UpdateType.CHAT_JOIN_REQUEST -> Update.ChatJoinRequestUpdate(
            updateId = updateId,
            chatJoinRequest = chatJoinRequest!!,
        )
        UpdateType.CHAT_BOOST -> Update.ChatBoostUpdate(
            updateId = updateId,
            chatBoost = chatBoost!!.sealed(),
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

sealed class Update(
    val updateId: Long,
) {
    class MessageUpdate(
        updateId: Long,
        val message: Message,
    ) : Update(updateId)

    class EditedMessageUpdate(
        updateId: Long,
        val editedMessage: Message,
    ) : Update(updateId)

    class ChannelPostUpdate(
        updateId: Long,
        val channelPost: Message,
    ) : Update(updateId)

    class EditedChannelPostUpdate(
        updateId: Long,
        val editedChannelPost: Message,
    ) : Update(updateId)

    class BusinessConnectionUpdate(
        updateId: Long,
        val businessConnection: BusinessConnection,
    ) : Update(updateId)

    class BusinessMessageUpdate(
        updateId: Long,
        val businessMessage: Message,
    ) : Update(updateId)

    class EditedBusinessMessageUpdate(
        updateId: Long,
        val editedBusinessMessage: Message,
    ) : Update(updateId)

    class DeletedBusinessMessagesUpdate(
        updateId: Long,
        val deletedBusinessMessages: BusinessMessagesDeleted,
    ) : Update(updateId)

    class MessageReactionUpdate(
        updateId: Long,
        val messageReaction: MessageReactionUpdated,
    ) : Update(updateId)

    class MessageReactionCountUpdate(
        updateId: Long,
        val messageReactionCount: MessageReactionCountUpdated,
    ) : Update(updateId)

    class InlineQueryUpdate(
        updateId: Long,
        val inlineQuery: InlineQuery,
    ) : Update(updateId)

    class ChosenInlineResultUpdate(
        updateId: Long,
        val chosenInlineResult: ChosenInlineResult,
    ) : Update(updateId)

    class CallbackQueryUpdate(
        updateId: Long,
        val callbackQuery: CallbackQuery,
    ) : Update(updateId)

    class ShippingQueryUpdate(
        updateId: Long,
        val shippingQuery: ShippingQuery,
    ) : Update(updateId)

    class PreCheckoutQueryUpdate(
        updateId: Long,
        val preCheckoutQuery: PreCheckoutQuery,
    ) : Update(updateId)

    class PollUpdate(
        updateId: Long,
        val poll: Poll?,
    ) : Update(updateId)

    class PollAnswerUpdate(
        updateId: Long,
        val pollAnswer: PollAnswer,
    ) : Update(updateId)

    class MyChatMemberUpdate(
        updateId: Long,
        val myChatMember: ChatMemberUpdated,
    ) : Update(updateId)

    class ChatMemberUpdate(
        updateId: Long,
        val chatMember: ChatMemberUpdated,
    ) : Update(updateId)

    class ChatJoinRequestUpdate(
        updateId: Long,
        val chatJoinRequest: ChatJoinRequest,
    ) : Update(updateId)

    class ChatBoostUpdate(
        updateId: Long,
        val chatBoost: ChatBoostUpdated,
    ) : Update(updateId)

    class RemovedChatBoostUpdate(
        updateId: Long,
        val removedChatBoost: ChatBoostRemoved,
    ) : Update(updateId)

    class UnknownUpdate(
        updateId: Long,
    ) : Update(updateId)
}