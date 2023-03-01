package com.arcquila.semarangtravel.ui.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.arcquila.semarangtravel.data.constant.Const
import com.arcquila.semarangtravel.ui.theme.backgroundColor
import com.arcquila.semarangtravel.ui.theme.orangeRed

@Composable
fun Empty(
    modifier: Modifier = Modifier,
    contentText: String
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .background(backgroundColor)
            .fillMaxSize()
    ) {
        Text(
            color = orangeRed,
            text = contentText,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
        )
    }

}

@Preview(showBackground = true)
@Composable
fun EmptyPreview() {
    Empty(
        contentText = Const.Cons.EMPTY,
    )
}