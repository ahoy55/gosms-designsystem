package ru.gosms.designsystem.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

@Composable
fun QuestionDialog(
    state: MutableState<Boolean>,
    title: String,
    text: String,
    cancelLabel: String,
    confirmButton: @Composable () -> Unit,
    onCancel: () -> Unit = {},
) {
    if (!state.value) return

    AlertDialog(
        onDismissRequest = { onCancel(); state.value = false },
        title = { Text(text = title) },
        text = { Text(text = text) },
        dismissButton = {
            TextButton(onClick = { onCancel(); state.value = false }) {
                Text(text = cancelLabel)
            }
        },
        confirmButton = confirmButton
    )
}
