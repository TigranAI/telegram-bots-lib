package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.ApiGodDto
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
            fill = fill!!.typify(),
            darkThemeDimming = darkThemeDimming!!,
        )
        BackgroundType.WALLPAPER -> Background.BackgroundTypeWallpaper(
            document = document!!,
            darkThemeDimming = darkThemeDimming!!,
            isBlurred = isBlurred,
            isMoving = isMoving,
        )
        BackgroundType.PATTERN -> Background.BackgroundTypePattern(
            document = document!!,
            fill = fill!!.typify(),
            intensity = intensity!!,
            isInverted = isInverted,
            isMoving = isMoving,
        )
        BackgroundType.CHAT_THEME -> Background.BackgroundTypeChatTheme(
            themeName = themeName!!,
        )
    }
}

interface Background {
    val type: BackgroundType

    data class BackgroundTypeFill(
        val fill: BackgroundFill,
        val darkThemeDimming: Boolean,
    ) : Background {
        override val type = BackgroundType.FILL
    }

    data class BackgroundTypeWallpaper(
        val document: Document,
        val darkThemeDimming: Boolean,
        val isBlurred: Boolean?,
        val isMoving: Boolean?,
    ) : Background {
        override val type = BackgroundType.WALLPAPER
    }

    data class BackgroundTypePattern(
        val document: Document,
        val fill: BackgroundFill,
        val intensity: Int,
        val isInverted: Boolean?,
        val isMoving: Boolean?,
    ) : Background {
        override val type = BackgroundType.PATTERN
    }

    data class BackgroundTypeChatTheme(
        val themeName: String,
    ) : Background {
        override val type = BackgroundType.CHAT_THEME
    }
}