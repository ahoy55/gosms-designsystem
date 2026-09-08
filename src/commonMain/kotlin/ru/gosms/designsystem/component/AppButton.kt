package ru.gosms.designsystem.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    title: String,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    icon: ImageVector? = null,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier
            .height(48.dp)
            .fillMaxWidth(),
        enabled = enabled && !isLoading,
        shape = RoundedCornerShape(12.dp),
        onClick = onClick,
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.height(20.dp),
                color = MaterialTheme.colorScheme.onPrimary,
                strokeWidth = 2.dp,
            )
        } else {
            Text(
                text = title,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onPrimary,
            )
            icon?.let {
                Icon(
                    modifier = Modifier.padding(start = 8.dp),
                    imageVector = icon,
                    contentDescription = null,
                )
            }
        }
    }
}
