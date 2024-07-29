package ru.tigran.telegram.bots.api.model.dto

data class ShippingQuery(
    val id: String,
    val from: User,
    val invoicePayload: String,
    val shippingAddress: ShippingAddress,
)
