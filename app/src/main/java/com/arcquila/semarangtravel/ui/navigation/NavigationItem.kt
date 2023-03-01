package com.arcquila.semarangtravel.ui.navigation

import androidx.compose.ui.graphics.painter.Painter

data class NavigationItem(
    val screen: Screen,
    val title: String,
    val icon: Painter
)
