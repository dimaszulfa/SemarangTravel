package com.arcquila.semarangtravel.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

private val colorPalette = lightColors(
    primary = cyan,
    primaryVariant = greenishCyan,
)

@Composable
fun SemarangTourismTheme(
    content: @Composable () -> Unit
) {
    val semarangTourismTypography = SemarangTourismTypography(
        body = TextStyle(
            fontFamily = fontFamily ,
            fontWeight = FontWeight.Medium
        ),
        title = TextStyle(
            fontFamily = fontFamily ,
            fontWeight = FontWeight.Bold
        ),
        caption = TextStyle(
            fontFamily = fontFamily ,
            fontWeight = FontWeight.Normal
        )
    )

    CompositionLocalProvider(
        LocalSemarangTourismTypography provides semarangTourismTypography
    ) {
        MaterialTheme(
            colors = colorPalette,
            content = content
        )
    }
}

object SemarangTourismTheme {
    val typography: SemarangTourismTypography
        @Composable
        get() = LocalSemarangTourismTypography.current
}