package ru.gosms.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * Семантические цветовые токены, специфичные для приложения.
 *
 * Material [ColorScheme] остаётся доступным через MaterialTheme.colorScheme
 * для стандартных компонентов (ripple, selection и т.п.), но прикладной UI
 * должен опираться на [AppColors] — здесь имена отражают роль, а не
 * абстрактную роль material.
 *
 * Доступ: AppTheme.colors.statusOkText
 */
@Immutable
data class AppColors(
    // Brand — акценты, ссылки, primary кнопки, активный таб
    val brand: Color,
    val brandOn: Color,             // что писать НА бирюзе (обычно белый)
    val brandSurface: Color,        // полупрозрачная бирюза для плашек
    val brandBorder: Color,         // полупрозрачная бирюза для обводок

    // Surface
    val bgPrimary: Color,           // основной фон экрана
    val bgSecondary: Color,         // фон карточек, плашек статистики
    val bgElevated: Color,          // приподнятые поверхности — модалки, шторки

    // Borders
    val borderSubtle: Color,        // 0.5dp разделители
    val borderStrong: Color,        // обводки инпутов, кнопок

    // Text
    val textPrimary: Color,
    val textSecondary: Color,
    val textTertiary: Color,        // метки секций, метаданные

    // Status — на связи / активно
    val statusOkBg: Color,
    val statusOkBorder: Color,
    val statusOkText: Color,

    // Status — внимание / приостановлено / очередь копится
    val statusWarnBg: Color,
    val statusWarnBorder: Color,
    val statusWarnText: Color,

    // Status — нет связи / ошибка
    val statusDangerBg: Color,
    val statusDangerBorder: Color,
    val statusDangerText: Color,

    // Поток (live-лог) — цвета направления событий
    val streamTx: Color,            // outgoing
    val streamRx: Color,            // incoming

    val outline: Color,

    val isLight: Boolean,
)

internal val LightAppColors = AppColors(
    brand = Palette.Brand,
    brandOn = Palette.White,
    brandSurface = Palette.Brand.copy(alpha = 0.15f),
    brandBorder = Palette.Brand.copy(alpha = 0.30f),

    bgPrimary = Palette.White,
    bgSecondary = Palette.Gray100,
    bgElevated = Palette.White,

    borderSubtle = Palette.Gray500,
    borderStrong = Palette.Gray300,

    textPrimary = Palette.Black,
    textSecondary = Palette.Gray600,
    textTertiary = Palette.Gray500,

    statusOkBg = Palette.SuccessBgLight,
    statusOkBorder = Palette.Success.copy(alpha = 0.25f),
    statusOkText = Palette.Success,

    statusWarnBg = Palette.WarningBgLight,
    statusWarnBorder = Palette.WarningBorderLight,
    statusWarnText = Palette.Warning,

    statusDangerBg = Palette.DangerBgLight,
    statusDangerBorder = Palette.DangerBorderLight,
    statusDangerText = Palette.Danger,

    streamTx = Palette.Brand,
    streamRx = Palette.Success,

    outline = Color(0x17000000),

    isLight = true,
)

internal val DarkAppColors = AppColors(
    brand = Palette.Brand,
    brandOn = Palette.White,
    brandSurface = Palette.Brand.copy(alpha = 0.12f),
    brandBorder = Palette.Brand.copy(alpha = 0.30f),

    bgPrimary = Palette.Dark0,
    bgSecondary = Palette.Dark1,
    bgElevated = Palette.Dark2,

    borderSubtle = Palette.Dark3,
    borderStrong = Palette.Dark4,

    textPrimary = Palette.DarkText,
    textSecondary = Palette.DarkTextMuted,
    textTertiary = Palette.DarkTextDim,

    statusOkBg = Palette.Brand.copy(alpha = 0.10f),
    statusOkBorder = Palette.Brand.copy(alpha = 0.30f),
    statusOkText = Palette.Brand,

    statusWarnBg = Palette.WarningDark.copy(alpha = 0.10f),
    statusWarnBorder = Palette.WarningDark.copy(alpha = 0.30f),
    statusWarnText = Palette.WarningDark,

    statusDangerBg = Palette.DangerDark.copy(alpha = 0.10f),
    statusDangerBorder = Palette.DangerDark.copy(alpha = 0.30f),
    statusDangerText = Palette.DangerDark,

    streamTx = Palette.streamTx,
    streamRx = Palette.streamRx,

    outline = Color(0x17FFFFFF),

    isLight = false,
)

/**
 * Дефолт нужен, чтобы превью не падали без обёртки AppTheme.
 * В реальном UI всегда переопределяется через AppTheme.
 */
val LocalAppColors = staticCompositionLocalOf { LightAppColors }
