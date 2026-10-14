package ru.gosms.designsystem.component

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import ru.gosms.designsystem.theme.AppTheme

data class AppBottomBarItem(val icon: ImageVector, val label: String)

/**
 * Плавающая нижняя панель: у выбранного пункта подсвечена «таблетка» и видна подпись.
 * Вёрстка и анимация — по BottomFloatBar из android-client.
 */
@Composable
fun AppBottomBar(
    items: List<AppBottomBarItem>,
    selectedIndex: Int,
    onSelect: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val density = LocalDensity.current
    val shape = AppTheme.shapes.md
    val containerColor = AppTheme.colors.brandSurface.compositeOver(AppTheme.colors.bgPrimary)
    val offsetSelected = remember { mutableStateOf<Offset?>(null) }
    val sizeSelected = remember { mutableStateOf<Size?>(null) }
    val offsetAnim = animateOffsetAsState(
        targetValue = offsetSelected.value ?: Offset.Zero,
        animationSpec = spring(stiffness = Spring.StiffnessLow),
    )
    val pillColor = AppTheme.colors.bgPrimary

    Box(
        modifier = modifier
            .shadow(4.dp, shape)
            .clip(shape)
            .background(containerColor)
            .pointerInput(Unit) { detectTapGestures { } },
    ) {
        Box(
            modifier = Modifier.drawBehind {
                val radius = with(density) { 10.dp.toPx() }
                drawRoundRect(
                    cornerRadius = CornerRadius(radius, radius),
                    color = pillColor,
                    topLeft = offsetAnim.value.takeIf { it != Offset.Zero }
                        ?: offsetSelected.value ?: Offset.Zero,
                    size = sizeSelected.value ?: Size.Zero,
                )
            },
        )
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            items.forEachIndexed { index, item ->
                val selected = index == selectedIndex
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .clip(shape)
                        .clickable(interactionSource = null, indication = null) { onSelect(index) }
                        .onPlaced {
                            if (selected) {
                                offsetSelected.value = it.positionInParent()
                                sizeSelected.value = it.size.toSize()
                            }
                        }
                        .padding(8.dp),
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = if (selected) null else item.label,
                            tint = if (selected) AppTheme.colors.textPrimary else AppTheme.colors.brand,
                        )
                        if (selected) {
                            Text(
                                text = item.label.lowercase(),
                                fontWeight = FontWeight.SemiBold,
                                style = AppTheme.typography.labelMd,
                                color = AppTheme.colors.textPrimary,
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun AppBottomBarPreview() {
    AppTheme {
        AppBottomBar(
            items = listOf(
                AppBottomBarItem(Icons.Default.Home, "Главная"),
                AppBottomBarItem(Icons.Default.Settings, "Ещё"),
            ),
            selectedIndex = 0,
            onSelect = {},
        )
    }
}
