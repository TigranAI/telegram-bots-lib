package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.enums.Currency

data class RefundedPayment(
    val currency: Currency,
    val totalAmount: Int,
    val invoicePayload: String,
    val telegramPaymentChargeId: String,
    val providerPaymentChargeId: String?,
)
