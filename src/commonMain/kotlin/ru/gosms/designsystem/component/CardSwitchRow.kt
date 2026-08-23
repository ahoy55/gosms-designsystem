package ru.gosms.designsystem.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ru.gosms.designsystem.theme.AppTheme

@Composable
fun CardSwitchRow(
    modifier: Modifier = Modifier,
    text: String,
    subtitle: String? = null,
    icon: ImageVector? = null,
    checked: Boolean,
    dividerVisible: Boolean = true,
    onCheckedChange: (Boolean) -> Unit,
) {
    Column {
        Row(
            modifier = modifier
                .heightIn(min = 56.dp)
                .clickable { onCheckedChange(!checked) }
                .padding(horizontal = 16.dp, vertical = 8.dp),
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
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = text,
                    style = AppTheme.typography.bodyMd,
                    fontWeight = FontWeight.Medium,
                )
                subtitle?.let {
                    Text(
                        text = it,
                        style = AppTheme.typography.bodySm,
                        color = AppTheme.colors.textTertiary,
                    )
                }
            }
            Switch(
                checked = checked,
                onCheckedChange = onCheckedChange,
                colors = SwitchDefaults.colors(
                    checkedThumbColor = AppTheme.colors.brandOn,
                    checkedTrackColor = AppTheme.colors.brand,
                    uncheckedThumbColor = AppTheme.colors.textTertiary,
                    uncheckedTrackColor = AppTheme.colors.brandSurface,
                    uncheckedBorderColor = AppTheme.colors.outline,
                )
            )
        }
        if (dividerVisible) {
            HorizontalDivider(color = AppTheme.colors.outline)
        }
    }
}
