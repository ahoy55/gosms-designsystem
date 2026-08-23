package ru.gosms.designsystem.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme

/**
 * Material ColorScheme на основе наших токенов.
 *
 * Нужен, чтобы стандартные Material 3 компоненты (AlertDialog, ripple,
 * выделение текста и т.п.) использовали наши цвета, если будут применены.
 *
 * В прикладном UI предпочитай AppTheme.colors — он точнее и нагляднее.
 */
internal fun materialColorSchemeFrom(colors: AppColors): ColorScheme =
    if (colors.isLight) {
        lightColorScheme(
            primary = colors.brand,
            onPrimary = colors.brandOn,
            primaryContainer = colors.brandSurface,
            onPrimaryContainer = colors.statusOkText,

            background = colors.bgPrimary,
            onBackground = colors.textPrimary,
            surface = colors.bgPrimary,
            onSurface = colors.textPrimary,
            surfaceVariant = colors.bgSecondary,
            onSurfaceVariant = colors.textSecondary,

            outline = colors.borderStrong,
            outlineVariant = colors.borderSubtle,

            error = colors.statusDangerText,
            onError = colors.brandOn,
            errorContainer = colors.statusDangerBg,
            onErrorContainer = colors.statusDangerText,
        )
    } else {
        darkColorScheme(
            primary = colors.brand,
            onPrimary = colors.brandOn,
            primaryContainer = colors.brandSurface,
            onPrimaryContainer = colors.brand,

            background = colors.bgPrimary,
            onBackground = colors.textPrimary,
            surface = colors.bgPrimary,
            onSurface = colors.textPrimary,
            surfaceVariant = colors.bgSecondary,
            onSurfaceVariant = colors.textSecondary,

            outline = colors.borderStrong,
            outlineVariant = colors.borderSubtle,

            error = colors.statusDangerText,
            onError = colors.brandOn,
            errorContainer = colors.statusDangerBg,
            onErrorContainer = colors.statusDangerText,
        )
    }
