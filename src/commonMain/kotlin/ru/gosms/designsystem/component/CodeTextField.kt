package ru.gosms.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.gosms.designsystem.theme.AppTheme

@Composable
fun CodeTextField(
    modifier: Modifier = Modifier,
    focusRequester: FocusRequester,
    numbersCount: Int,
    value: String = "",
    error: String? = null,
    enabled: Boolean = true,
    onChangeValue: (String) -> Unit,
    onDone: () -> Unit = {},
) {
    BasicTextField(
        modifier = modifier
            .focusRequester(focusRequester)
            .widthIn(max = 400.dp),
        enabled = enabled,
        value = value,
        onValueChange = { newValue ->
            if (newValue.all { it.isDigit() } && newValue.length <= numbersCount) {
                onChangeValue(newValue)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            .copy(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = { onDone() }),
        decorationBox = {
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                repeat(numbersCount) { index ->
                    val char = value.getOrNull(index) ?: '-'
                    Box(
                        modifier = Modifier
                            .clip(AppTheme.shapes.sm)
                            .weight(1f)
                            .background(
                                if (error != null) {
                                    AppTheme.colors.statusDangerBg
                                } else {
                                    AppTheme.colors.brandSurface
                                }
                            )
                            .border(
                                1.dp,
                                AppTheme.colors.brandBorder,
                                AppTheme.shapes.sm
                            )
                            .padding(4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            modifier = Modifier.padding(4.dp),
                            text = char.toString(),
                            style = AppTheme.typography.mono,
                            fontSize = 24.sp,        // OTP digit — larger than default mono
                            fontWeight = FontWeight.Bold,
                            color = if (!error.isNullOrEmpty()) {
                                MaterialTheme.colorScheme.error
                            } else {
                                MaterialTheme.colorScheme.primary
                            }
                        )
                    }
                }
            }
        }
    )

    if (error != null) {
        Text(
            text = error,
            style = AppTheme.typography.bodyMd,
            color = AppTheme.colors.statusDangerText
        )
    }
}
