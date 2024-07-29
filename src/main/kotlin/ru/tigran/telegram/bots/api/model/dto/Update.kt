package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.enums.UpdateType

data class Update(
    val updateId: Long,
    val message: Message?,
    val editedMessage: Message?,
    val channelPost: Message?,
    val editedChannelPost: Message?,
    //val businessConnection: BusinessConnection?,
    val businessMessage: Message?,
    val editedBusinessMessage: Message?,
    //val deletedBusinessMessages: BusinessMessagesDeleted?,
    //val messageReaction: MessageReactionUpdated?,
    //val messageReactionCount: MessageReactionCountUpdated?,
    //val inlineQuery: InlineQuery?,
    //val chosenInlineResult: ChosenInlineResult?,
    //val callbackQuery: CallbackQuery?,
    //val shippingQuery: ShippingQuery?,
    //val preCheckoutQuery: PreCheckoutQuery?,
    //val poll: Poll?,
    //val pollAnswer: PollAnswer?,
    //val myChatMember: ChatMemberUpdated?,
    //val chatMember: ChatMemberUpdated?,
    //val chatJoinRequest: ChatJoinRequest?,
    //val chatBoost: ChatBoostUpdated?,
    //val removedChatBoost: ChatBoostRemoved?,
) {
    val type: UpdateType
        get() = when {
            message != null -> UpdateType.MESSAGE
            else -> UpdateType.UNKNOWN
        }
}