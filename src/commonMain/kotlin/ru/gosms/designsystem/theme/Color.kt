package ru.gosms.designsystem.theme

import androidx.compose.ui.graphics.Color

/**
 * Сырые цветовые значения. Не используются напрямую в UI —
 * только через [AppColors] и Material [ColorScheme].
 *
 * Если нужен новый цвет — добавляй сюда, потом маппи в семантику.
 */
internal object Palette {
    // Brand
    val Brand = Color(0xFF0D9394)
    val BrandSoft = Color(0xFF14B8B9)   // светлее, для тёмной темы и hover-состояний
    val BrandDeep = Color(0xFF0A6A6B)   // темнее, для текста на светлом фоне

    // Neutrals — light
    val White = Color(0xFFFFFFFF)
    val Gray50 = Color(0xFFFAFAFA)
    val Gray100 = Color(0xFFF5F5F5)
    val Gray200 = Color(0xFFE5E5E5)
    val Gray300 = Color(0xFFD4D4D4)
    val Gray500 = Color(0xFF737373)
    val Gray600 = Color(0xFF525252)
    val Gray900 = Color(0xFF171717)
    val Black = Color(0xFF0A0A0A)

    // Neutrals — dark
    val Dark0 = Color(0xFF0A0A0A)       // основной фон
    val Dark1 = Color(0xFF111111)       // карточки
    val Dark2 = Color(0xFF1A1A1A)       // приподнятые поверхности (модалки)
    val Dark3 = Color(0xFF1F1F1F)       // обводки
    val Dark4 = Color(0xFF2A2A2A)       // обводки приподнятые
    val DarkText = Color(0xFFFAFAFA)
    val DarkTextMuted = Color(0xFF999999)
    val DarkTextDim = Color(0xFF666666)
    val DarkTextFaint = Color(0xFF555555)

    // Semantic — success
    val Success = Color(0xFF16A34A)
    val SuccessDark = Color(0xFF22C55E)
    val SuccessBgLight = Color(0xFFF0FBF8)
    val SuccessTextLight = Color(0xFF166534)

    // Semantic — warning
    val Warning = Color(0xFFB45309)
    val WarningDark = Color(0xFFEAB308)
    val WarningBgLight = Color(0xFFFFFBEB)
    val WarningBorderLight = Color(0xFFFCD34D)

    // Semantic — danger
    val Danger = Color(0xFFDC2626)
    val DangerDark = Color(0xFFEF4444)
    val DangerBgLight = Color(0xFFFAE6E6)
    val DangerBorderLight = Color(0xFFFECACA)

    val outline = Color(0x17FFFFFF)

    val streamRx = Color(0xFF2196F3)
    val streamTx = Color(0xFF16A34A)
}
