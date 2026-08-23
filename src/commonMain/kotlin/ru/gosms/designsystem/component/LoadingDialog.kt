package ru.gosms.designsystem.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import ru.gosms.designsystem.theme.AppTheme

@Composable
fun LoadingDialog(
    state: MutableState<Boolean>,
    title: String,
    cancelLabel: String,
    onCancel: () -> Unit,
) {
    if (!state.value) return

    AlertDialog(
        shape = AppTheme.shapes.lg,
        onDismissRequest = { state.value = false },
        title = { Text(text = title) },
        text = { LinearProgressIndicator() },
        confirmButton = {
            TextButton(
                onClick = { onCancel(); state.value = false },
                shape = AppTheme.shapes.md,
            ) {
                Text(text = cancelLabel)
            }
        }
    )
}
