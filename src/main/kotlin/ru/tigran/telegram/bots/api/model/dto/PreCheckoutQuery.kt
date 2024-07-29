package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.enums.Currency

data class PreCheckoutQuery(
    val id: String,
    val from: User,
    val currency: Currency,
    val totalAmount: Int,
    val invoicePayload: String,
    val shippingOptionId: String?,
    val orderInfo: OrderInfo?,
)
