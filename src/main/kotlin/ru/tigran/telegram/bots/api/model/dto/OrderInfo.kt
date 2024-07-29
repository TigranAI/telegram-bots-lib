package ru.tigran.telegram.bots.api.model.dto

data class OrderInfo(
    val name: String?,
    val phoneNumber: String?,
    val email: String?,
    val shippingAddress: ShippingAddress?,
)
