package ru.gosms.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import ru.gosms.designsystem.generated.resources.Res
import ru.gosms.designsystem.generated.resources.inter
import ru.gosms.designsystem.generated.resources.inter_medium
import ru.gosms.designsystem.generated.resources.inter_semibold
import ru.gosms.designsystem.generated.resources.jetbrains_mono
import ru.gosms.designsystem.generated.resources.jetbrains_mono_medium
import org.jetbrains.compose.resources.Font

// ============================================================
// Type scale
// ============================================================
//
// 8 tokens cover every visual role in the app.
// Add a new token only when a genuinely new visual role appears.
//
//  topBar  — 28sp SemiBold            — navigation / page title
//  titleMd — 20sp SemiBold            — section / card / dialog heading
//  bodyMd  — 16sp Normal              — primary body text
//  bodySm  — 14sp Normal              — secondary / supporting text
//  labelMd — 14sp Medium, 0.8sp track — ALL-CAPS section labels
//  labelSm — 12sp Normal              — captions, warnings, small status
//  mono    — 14sp Medium  JBMono      — data values, phone numbers, IDs
//  monoSm  — 14sp Normal  JBMono      — live log / stream entries

@Immutable
data class AppTypography(
    /** 28sp SemiBold — navigation / page title. */
    val topBar: TextStyle,
    /** 20sp SemiBold — section heading, dialog title, card title. */
    val titleMd: TextStyle,
    /** 16sp Normal — primary body text in cards and rows. */
    val bodyMd: TextStyle,
    /** 14sp Normal — secondary / supporting text. */
    val bodySm: TextStyle,
    /** 14sp Medium, 0.8sp tracking — ALL-CAPS section labels ("КАНАЛЫ", "НА СВЯЗИ"). */
    val labelMd: TextStyle,
    /** 12sp Normal — captions, warning annotations, small status labels. */
    val labelSm: TextStyle,
    /** 14sp Medium JetBrainsMono — data values, phone numbers, IDs, timestamps. */
    val mono: TextStyle,
    /** 14sp Normal JetBrainsMono — live log / stream entries. */
    val monoSm: TextStyle,
)

/**
 * Composable, а не top-level val: шрифты в Compose Multiplatform грузятся через
 * org.jetbrains.compose.resources.Font(), которая сама @Composable (в отличие от
 * androidx.compose.ui.text.font.Font()).
 */
@Composable
internal fun defaultAppTypography(): AppTypography {
    val inter = FontFamily(
        Font(Res.font.inter, FontWeight.Normal),
        Font(Res.font.inter_medium, FontWeight.Medium),
        Font(Res.font.inter_semibold, FontWeight.SemiBold),
    )
    val jetBrainsMono = FontFamily(
        Font(Res.font.jetbrains_mono, FontWeight.Normal),
        Font(Res.font.jetbrains_mono_medium, FontWeight.Medium),
    )

    return AppTypography(
        topBar = TextStyle(
            fontFamily = inter,
            fontWeight = FontWeight.SemiBold,
            fontSize = 28.sp,
            lineHeight = 1.3.em,
        ),
        titleMd = TextStyle(
            fontFamily = inter,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            lineHeight = 1.3.em,
        ),
        bodyMd = TextStyle(
            fontFamily = inter,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 1.5.em,
        ),
        bodySm = TextStyle(
            fontFamily = inter,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 1.3.em,
        ),
        labelMd = TextStyle(
            fontFamily = inter,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            letterSpacing = 0.8.sp,
        ),
        labelSm = TextStyle(
            fontFamily = inter,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 1.4.em,
        ),
        mono = TextStyle(
            fontFamily = jetBrainsMono,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            lineHeight = 1.2.em,
        ),
        monoSm = TextStyle(
            fontFamily = jetBrainsMono,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 1.2.em,
        ),
    )
}

val LocalAppTypography = staticCompositionLocalOf<AppTypography> {
    error("AppTypography недоступна без обёртки AppTheme { ... }")
}
