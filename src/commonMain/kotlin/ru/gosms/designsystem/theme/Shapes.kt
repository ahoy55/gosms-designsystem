package ru.gosms.designsystem.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

/**
 * Системные радиусы.
 *
 * Принцип: маленькие радиусы для технического стиля.
 * Если задача требует «дружелюбного» — увеличивай локально, не трогая токены.
 */
@Immutable
data class AppShapes(
    val sm: RoundedCornerShape,      // мелкие плашки, чипы, инпуты
    val md: RoundedCornerShape,      // карточки
    val lg: RoundedCornerShape,      // модалки, диалоги
)

internal val DefaultAppShapes = AppShapes(
    sm = RoundedCornerShape(6.dp),
    md = RoundedCornerShape(10.dp),
    lg = RoundedCornerShape(16.dp),
)

val LocalAppShapes = staticCompositionLocalOf { DefaultAppShapes }
