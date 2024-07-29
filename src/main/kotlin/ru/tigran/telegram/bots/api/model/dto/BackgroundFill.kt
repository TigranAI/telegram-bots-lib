package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.enums.BackgroundFillType

data class BackgroundFill(
    val type: BackgroundFillType,
    val color: Int?,
    val topColor: Int?,
    val bottomColor: Int?,
    val rotationAngle: Int?,
    val colors: List<Int>?,
) {
    fun sealed() = when(type) {
        BackgroundFillType.SOLID -> BackgroundFillSealed.BackgroundFillSolid(
            type = type,
            color = color!!,
        )
        BackgroundFillType.GRADIENT -> BackgroundFillSealed.BackgroundFillGradient(
            type = type,
            topColor = topColor!!,
            bottomColor = bottomColor!!,
            rotationAngle = rotationAngle!!,
        )
        BackgroundFillType.FREEFORM_GRADIENT -> BackgroundFillSealed.BackgroundFillFreeformGradient(
            type = type,
            colors = colors!!,
        )
    }
}

sealed class BackgroundFillSealed {
    class BackgroundFillSolid(
        val type: BackgroundFillType,
        val color: Int,
    ) : BackgroundFillSealed()

    class BackgroundFillGradient(
        val type: BackgroundFillType,
        val topColor: Int,
        val bottomColor: Int,
        val rotationAngle: Int,
    ) : BackgroundFillSealed()

    class BackgroundFillFreeformGradient(
        val type: BackgroundFillType,
        val colors: List<Int>,
    ) : BackgroundFillSealed()
}
