package ru.gosms.designsystem.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ru.gosms.designsystem.theme.AppTheme

@Composable
fun CardColumn(modifier: Modifier = Modifier, content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = modifier
            .clip(AppTheme.shapes.md)
            .border(1.dp, AppTheme.colors.outline, AppTheme.shapes.md)
    ) {
        content()
    }
}

@Composable
fun CardRow(
    modifier: Modifier = Modifier,
    text: String,
    option: String? = null,
    icon: ImageVector? = null,
    arrowIcon: ImageVector = Icons.Default.ChevronRight,
    dividerVisible: Boolean = true,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    Column {
        Row(
            modifier = modifier
                .alpha(if (enabled) 1f else .3f)
                .heightIn(min = 52.dp)
                .clickable(onClick = onClick, enabled = enabled)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            icon?.let {
                Icon(
                    modifier = Modifier.padding(end = 16.dp),
                    imageVector = icon,
                    contentDescription = null,
                    tint = AppTheme.colors.brand
                )
            }
            Text(
                modifier = Modifier.weight(1f),
                text = text,
                style = AppTheme.typography.bodyMd,
                fontWeight = FontWeight.Medium,
            )
            option?.let {
                Text(
                    text = it,
                    style = AppTheme.typography.bodySm,
                    color = AppTheme.colors.textTertiary
                )
            }
            Icon(
                imageVector = arrowIcon,
                contentDescription = null,
                tint = AppTheme.colors.textTertiary,
            )
        }
        if (dividerVisible) {
            HorizontalDivider(color = AppTheme.colors.outline)
        }
    }
}
