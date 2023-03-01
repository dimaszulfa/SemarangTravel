package com.arcquila.semarangtravel.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.arcquila.semarangtravel.SemarangTourismApp
import com.arcquila.semarangtravel.ui.theme.SemarangTourismTheme
import com.arcquila.semarangtravel.ui.theme.backgroundColor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SemarangTourismTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = backgroundColor
                ) {
                    SemarangTourismApp()
                }
            }
        }
    }
}