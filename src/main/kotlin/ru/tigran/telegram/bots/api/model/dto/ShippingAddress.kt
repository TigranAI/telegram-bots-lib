package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.enums.CountryCode

data class ShippingAddress(
    val countryCode: CountryCode,
    val state: String,
    val city: String,
    val streetLine1: String,
    val streetLine2: String,
    val postCode: String,
)
