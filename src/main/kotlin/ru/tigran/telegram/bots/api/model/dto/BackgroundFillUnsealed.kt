package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.enums.BackgroundFillType

data class BackgroundFillUnsealed(
    val type: BackgroundFillType,
    val color: Int?,
    val topColor: Int?,
    val bottomColor: Int?,
    val rotationAngle: Int?,
    val colors: List<Int>?,
) {
    fun sealed() = when(type) {
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

sealed class BackgroundFill {
    class BackgroundFillSolid(
        val type: BackgroundFillType,
        val color: Int,
    ) : BackgroundFill()

    class BackgroundFillGradient(
        val type: BackgroundFillType,
        val topColor: Int,
        val bottomColor: Int,
        val rotationAngle: Int,
    ) : BackgroundFill()

    class BackgroundFillFreeformGradient(
        val type: BackgroundFillType,
        val colors: List<Int>,
    ) : BackgroundFill()
}
