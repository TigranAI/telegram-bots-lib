package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.ApiGodDto
import ru.tigran.telegram.bots.api.model.enums.BackgroundFillType

data class BackgroundFillApi(
    val type: BackgroundFillType,
    val color: Int?,
    val topColor: Int?,
    val bottomColor: Int?,
    val rotationAngle: Int?,
    val colors: List<Int>?,
) : ApiGodDto<BackgroundFill> {
    override fun typify() = when(type) {
        BackgroundFillType.SOLID -> BackgroundFill.BackgroundFillSolid(
            color = color!!,
        )
        BackgroundFillType.GRADIENT -> BackgroundFill.BackgroundFillGradient(
            topColor = topColor!!,
            bottomColor = bottomColor!!,
            rotationAngle = rotationAngle!!,
        )
        BackgroundFillType.FREEFORM_GRADIENT -> BackgroundFill.BackgroundFillFreeformGradient(
            colors = colors!!,
        )
    }
}

interface BackgroundFill {
    val type: BackgroundFillType

    data class BackgroundFillSolid(
        val color: Int,
    ) : BackgroundFill {
        override val type = BackgroundFillType.SOLID
    }

    data class BackgroundFillGradient(
        val topColor: Int,
        val bottomColor: Int,
        val rotationAngle: Int,
    ) : BackgroundFill {
        override val type = BackgroundFillType.GRADIENT
    }

    data class BackgroundFillFreeformGradient(
        val colors: List<Int>,
    ) : BackgroundFill {
        override val type = BackgroundFillType.FREEFORM_GRADIENT
    }
}
