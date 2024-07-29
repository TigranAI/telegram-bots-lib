package ru.tigran.telegram.bots.api.model.dto

data class MaskPosition(
    val point: String,
    val xShift: Float,
    val yShift: Float,
    val scale: Float,
)
