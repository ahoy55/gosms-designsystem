package ru.gosms.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Inbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.gosms.designsystem.theme.AppTheme

/**
 * Заглушка по центру экрана для пустого списка или ошибки загрузки.
 * Кнопка действия (например, «Повторить») показывается, если заданы оба параметра.
 */
@Composable
fun StatePlaceholder(
    title: String,
    modifier: Modifier = Modifier,
    message: String? = null,
    icon: ImageVector = Icons.Default.Inbox,
    actionLabel: String? = null,
    onAction: (() -> Unit)? = null,
) {
    Column(
        modifier = modifier.fillMaxSize().padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(imageVector = icon, contentDescription = null, tint = AppTheme.colors.textTertiary)
        Text(
            text = title,
            style = AppTheme.typography.titleMd,
            color = AppTheme.colors.textPrimary,
            textAlign = TextAlign.Center,
        )
        if (message != null) {
            Text(
                text = message,
                style = AppTheme.typography.bodyMd,
                color = AppTheme.colors.textTertiary,
                textAlign = TextAlign.Center,
            )
        }
        if (actionLabel != null && onAction != null) {
            AppButton(title = actionLabel, onClick = onAction)
        }
    }
}

@Preview
@Composable
private fun StatePlaceholderPreview() {
    AppTheme {
        StatePlaceholder(
            title = "Пока пусто",
            message = "Отправленные сообщения появятся здесь",
            actionLabel = "Повторить",
            onAction = {},
        )
    }
}
