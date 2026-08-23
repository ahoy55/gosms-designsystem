package ru.gosms.designsystem.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.gosms.designsystem.theme.AppTheme

/**
 * title/text — обычные String, а не @StringRes Int: у общего пакета нет доступа к R-классу
 * приложения-потребителя. Резолвить строку (stringResource(...)) нужно на стороне вызова,
 * до записи в state — включая случаи, когда состояние выставляется вне композиции
 * (например, из LaunchedEffect.collect), там строку нужно заранее прочитать в composable-теле.
 */
sealed class AppDialogState {
    abstract val title: String

    data class Loading(override val title: String, val progress: String? = null) : AppDialogState()
    data class Error(override val title: String, val text: String) : AppDialogState()
}

@Composable
fun InfoDialog(
    state: MutableState<AppDialogState?>,
    cancelLabel: String,
    okLabel: String,
    onCancel: () -> Unit = {},
) {
    val value = state.value ?: return

    AlertDialog(
        onDismissRequest = { onCancel(); state.value = null },
        title = { Text(text = value.title) },
        text = {
            when (value) {
                is AppDialogState.Loading -> {
                    Column {
                        LinearProgressIndicator()
                        if (value.progress != null) {
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = value.progress, style = AppTheme.typography.bodySm)
                        }
                    }
                }

                is AppDialogState.Error -> Text(text = value.text)
            }
        },
        confirmButton = {
            TextButton(onClick = { onCancel(); state.value = null }) {
                Text(text = if (value is AppDialogState.Loading) cancelLabel else okLabel)
            }
        }
    )
}
