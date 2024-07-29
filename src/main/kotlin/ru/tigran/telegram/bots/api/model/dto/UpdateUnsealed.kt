package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.enums.UpdateType

data class UpdateUnsealed(
    val updateId: Long,
    val message: Message?,
    val editedMessage: Message?,
    val channelPost: Message?,
    val editedChannelPost: Message?,
    val businessConnection: BusinessConnection?,
    val businessMessage: Message?,
    val editedBusinessMessage: Message?,
    val deletedBusinessMessages: BusinessMessagesDeleted?,
    val messageReaction: MessageReactionUpdated?,
    val messageReactionCount: MessageReactionCountUpdated?,
    val inlineQuery: InlineQuery?,
    val chosenInlineResult: ChosenInlineResult?,
    val callbackQuery: CallbackQuery?,
    val shippingQuery: ShippingQuery?,
    val preCheckoutQuery: PreCheckoutQuery?,
    val poll: Poll?,
    val pollAnswer: PollAnswer?,
    val myChatMember: ChatMemberUpdated?,
    val chatMember: ChatMemberUpdated?,
    val chatJoinRequest: ChatJoinRequest?,
    val chatBoost: ChatBoostUpdated?,
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
}