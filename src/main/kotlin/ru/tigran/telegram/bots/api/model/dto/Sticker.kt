package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.enums.StickerType

data class Sticker(
    val fileId: String,
    val fileUniqueId: String,
    val type: StickerType,
    val width: Int,
    val height: Int,
    val isAnimated: Boolean,
    val isVideo: Boolean,
    val thumbnail: PhotoSize?,
    val emoji: String?,
    val setName: String?,
    val premiumAnimation: File?,
    val maskPosition: MaskPosition?,
    val customEmojiId: String?,
    val needsRepainting: Boolean?,
    val fileSize: Long?,
)
