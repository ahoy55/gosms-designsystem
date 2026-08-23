package ru.gosms.designsystem.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import ru.gosms.designsystem.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title: String,
    scrollBehavior: TopAppBarScrollBehavior?,
    maxLines: Int = 1,
    onBack: (() -> Unit)? = null,
    actions: @Composable () -> Unit = {},
) {
    // Use compact size for multi-line titles (e.g. long legal document names).
    val fontSize = if (maxLines == 1) AppTheme.typography.topBar.fontSize else 24.sp

    TopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = title,
                fontSize = fontSize,
                maxLines = maxLines,
                overflow = TextOverflow.Ellipsis,
                style = AppTheme.typography.topBar,
                color = AppTheme.colors.textPrimary,
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            scrolledContainerColor = Color.Transparent,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
        ),
        navigationIcon = {
            onBack?.let {
                IconButton(onBack) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimary,
                    )
                }
            }
        },
        actions = { actions() },
    )
}
