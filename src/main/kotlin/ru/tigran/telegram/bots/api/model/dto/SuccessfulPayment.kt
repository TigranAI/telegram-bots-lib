package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.enums.Currency

data class SuccessfulPayment(
    val currency: Currency,
    val totalAmount: Int,
    val invoicePayload: String,
    val shippingOptionId: String?,
    val orderInfo: OrderInfo?,
    val telegramPaymentChargeId: String,
    val providerPaymentChargeId: String,
)
