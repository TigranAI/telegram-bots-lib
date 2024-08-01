package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.enums.BackgroundType

data class BackgroundApi(
    val type: BackgroundType,
    val fill: BackgroundFillApi?,
    val darkThemeDimming: Boolean?,
    val document: Document?,
    val isBlurred: Boolean?,
    val isMoving: Boolean?,
    val intensity: Int?,
    val isInverted: Boolean?,
    val themeName: String?,
) : ApiGodDto<Background> {
    override fun typify() = when(type) {
        BackgroundType.FILL -> Background.BackgroundTypeFill(
            type = type,
            fill = fill!!.typify(),
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
            fill = fill!!.typify(),
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

interface Background {
    val type: BackgroundType

    data class BackgroundTypeFill(
        override val type: BackgroundType,
        val fill: BackgroundFill,
        val darkThemeDimming: Boolean,
    ) : Background

    data class BackgroundTypeWallpaper(
        override val type: BackgroundType,
        val document: Document,
        val darkThemeDimming: Boolean,
        val isBlurred: Boolean?,
        val isMoving: Boolean?,
    ) : Background

    data class BackgroundTypePattern(
        override val type: BackgroundType,
        val document: Document,
        val fill: BackgroundFill,
        val intensity: Int,
        val isInverted: Boolean?,
        val isMoving: Boolean?,
    ) : Background

    data class BackgroundTypeChatTheme(
        override val type: BackgroundType,
        val themeName: String,
    ) : Background
}