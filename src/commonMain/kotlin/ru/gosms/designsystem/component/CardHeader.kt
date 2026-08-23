package ru.gosms.designsystem.component

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.gosms.designsystem.theme.AppTheme

@Composable
fun ColumnScope.CardHeader(modifier: Modifier = Modifier, header: String) {
    Text(
        modifier = Modifier
            .align(Alignment.Start)
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp, bottom = 8.dp),
        text = header,
        color = MaterialTheme.colorScheme.onPrimary,
        style = AppTheme.typography.topBar,
    )
}
