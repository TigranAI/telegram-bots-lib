package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.enums.BackgroundType

data class Background(
    val type: BackgroundType,
    val fill: BackgroundFill?,
    val darkThemeDimming: Boolean?,
    val document: Document?,
    val isBlurred: Boolean?,
    val isMoving: Boolean?,
    val intensity: Int?,
    val isInverted: Boolean?,
    val themeName: String?,
) {
    fun sealed() = when(type) {
        BackgroundType.FILL -> BackgroundSealed.BackgroundTypeFill(
            type = type,
            fill = fill!!.sealed(),
            darkThemeDimming = darkThemeDimming!!,
        )
        BackgroundType.WALLPAPER -> BackgroundSealed.BackgroundTypeWallpaper(
            type = type,
            document = document!!,
            darkThemeDimming = darkThemeDimming!!,
            isBlurred = isBlurred,
            isMoving = isMoving,
        )
        BackgroundType.PATTERN -> BackgroundSealed.BackgroundTypePattern(
            type = type,
            document = document!!,
            fill = fill!!.sealed(),
            intensity = intensity!!,
            isInverted = isInverted,
            isMoving = isMoving,
        )
        BackgroundType.CHAT_THEME -> BackgroundSealed.BackgroundTypeChatTheme(
            type = type,
            themeName = themeName!!,
        )
    }
}

sealed class BackgroundSealed {
    class BackgroundTypeFill(
        val type: BackgroundType,
        val fill: BackgroundFillSealed,
        val darkThemeDimming: Boolean,
    ) : BackgroundSealed()

    class BackgroundTypeWallpaper(
        val type: BackgroundType,
        val document: Document,
        val darkThemeDimming: Boolean,
        val isBlurred: Boolean?,
        val isMoving: Boolean?,
    ) : BackgroundSealed()

    class BackgroundTypePattern(
        val type: BackgroundType,
        val document: Document,
        val fill: BackgroundFillSealed,
        val intensity: Int,
        val isInverted: Boolean?,
        val isMoving: Boolean?,
    ) : BackgroundSealed()

    class BackgroundTypeChatTheme(
        val type: BackgroundType,
        val themeName: String,
    ) : BackgroundSealed()
}