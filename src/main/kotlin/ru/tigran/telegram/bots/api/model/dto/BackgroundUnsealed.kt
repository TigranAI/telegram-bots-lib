package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.enums.BackgroundType

data class BackgroundUnsealed(
    val type: BackgroundType,
    val fill: BackgroundFillUnsealed?,
    val darkThemeDimming: Boolean?,
    val document: Document?,
    val isBlurred: Boolean?,
    val isMoving: Boolean?,
    val intensity: Int?,
    val isInverted: Boolean?,
    val themeName: String?,
) {
    fun sealed() = when(type) {
        BackgroundType.FILL -> Background.BackgroundTypeFill(
            type = type,
            fill = fill!!.sealed(),
            darkThemeDimming = darkThemeDimming!!,
        )
        BackgroundType.WALLPAPER -> Background.BackgroundTypeWallpaper(
            type = type,
            document = document!!,
            darkThemeDimming = darkThemeDimming!!,
            isBlurred = isBlurred,
            isMoving = isMoving,
        )
        BackgroundType.PATTERN -> Background.BackgroundTypePattern(
            type = type,
            document = document!!,
            fill = fill!!.sealed(),
            intensity = intensity!!,
            isInverted = isInverted,
            isMoving = isMoving,
        )
        BackgroundType.CHAT_THEME -> Background.BackgroundTypeChatTheme(
            type = type,
            themeName = themeName!!,
        )
    }
}

sealed class Background {
    class BackgroundTypeFill(
        val type: BackgroundType,
        val fill: BackgroundFill,
        val darkThemeDimming: Boolean,
    ) : Background()

    class BackgroundTypeWallpaper(
        val type: BackgroundType,
        val document: Document,
        val darkThemeDimming: Boolean,
        val isBlurred: Boolean?,
        val isMoving: Boolean?,
    ) : Background()

    class BackgroundTypePattern(
        val type: BackgroundType,
        val document: Document,
        val fill: BackgroundFill,
        val intensity: Int,
        val isInverted: Boolean?,
        val isMoving: Boolean?,
    ) : Background()

    class BackgroundTypeChatTheme(
        val type: BackgroundType,
        val themeName: String,
    ) : Background()
}