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
            type = type,
            color = color!!,
        )
        BackgroundFillType.GRADIENT -> BackgroundFill.BackgroundFillGradient(
            type = type,
            topColor = topColor!!,
            bottomColor = bottomColor!!,
            rotationAngle = rotationAngle!!,
        )
        BackgroundFillType.FREEFORM_GRADIENT -> BackgroundFill.BackgroundFillFreeformGradient(
            type = type,
            colors = colors!!,
        )
    }
}

interface BackgroundFill {
    val type: BackgroundFillType

    data class BackgroundFillSolid(
        override val type: BackgroundFillType,
        val color: Int,
    ) : BackgroundFill

    data class BackgroundFillGradient(
        override val type: BackgroundFillType,
        val topColor: Int,
        val bottomColor: Int,
        val rotationAngle: Int,
    ) : BackgroundFill

    data class BackgroundFillFreeformGradient(
        override val type: BackgroundFillType,
        val colors: List<Int>,
    ) : BackgroundFill
}
