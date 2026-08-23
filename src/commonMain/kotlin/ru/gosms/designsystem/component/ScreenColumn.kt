package ru.gosms.designsystem.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ScreenSurface(modifier: Modifier = Modifier, content: @Composable BoxScope.() -> Unit) {
    Box(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .fillMaxSize() then modifier
    ) {
        content()
    }
}

@Composable
fun ScreenColumn(
    modifier: Modifier = Modifier,
    scrollable: Boolean = true,
    content: @Composable ColumnScope.() -> Unit,
) {
    ScreenSurface {
        Column(
            modifier = Modifier.fillMaxSize() then (if (scrollable)
                Modifier.verticalScroll(rememberScrollState()) else
                Modifier)
                    then modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            content()
        }
    }
}
