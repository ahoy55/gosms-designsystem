package ru.gosms.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

/**
 * Корневая тема приложения. Оборачивай главное содержимое:
 *
 *   setContent {
 *       AppTheme { HomeScreen() }
 *   }
 *
 * Внутри читай токены через объект [AppTheme]:
 *
 *   Text(
 *       text = "...",
 *       color = AppTheme.colors.textPrimary,
 *       style = AppTheme.typography.titleMd,
 *   )
 *
 * @param darkTheme если null — следует за системой (рекомендуется).
 *                  Передавай явное значение когда юзер выбрал тему
 *                  в настройках приложения (Светлая/Тёмная/Системная).
 */
@Composable
fun AppTheme(
    darkTheme: Boolean? = null,
    content: @Composable () -> Unit,
) {
    val isDark = darkTheme ?: isSystemInDarkTheme()
    val colors = if (isDark) DarkAppColors else LightAppColors

    CompositionLocalProvider(
        LocalAppColors provides colors,
        LocalAppTypography provides defaultAppTypography(),
        LocalAppShapes provides DefaultAppShapes,
    ) {
        MaterialTheme(
            colorScheme = materialColorSchemeFrom(colors),
            // typography и shapes для Material компонентов оставляем дефолтные —
            // в нашем UI мы их не используем, а если понадобится AlertDialog,
            // он возьмёт системные стили
            content = content,
        )
    }
}

/**
 * Аксессор для семантических токенов. Использовать вместо MaterialTheme
 * во всём прикладном UI.
 *
 *   AppTheme.colors.brand
 *   AppTheme.typography.monoSm
 *   AppTheme.shapes.md
 */
object AppTheme {
    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalAppColors.current

    val typography: AppTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalAppTypography.current

    val shapes: AppShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalAppShapes.current
}
