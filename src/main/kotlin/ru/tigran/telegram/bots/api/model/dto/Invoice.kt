package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.enums.Currency

data class Invoice(
    val title: String,
    val description: String,
    val startParameter: String,
    val currency: Currency,
    val totalAmount: Int,
)
