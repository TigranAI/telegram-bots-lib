package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.enums.PaidMediaType

data class PaidMedia(
    val type: PaidMediaType,
    val width: Int?,
    val height: Int?,
    val duration: Int?,
    val photo: List<PhotoSize>?,
    val video: Video?,
)
