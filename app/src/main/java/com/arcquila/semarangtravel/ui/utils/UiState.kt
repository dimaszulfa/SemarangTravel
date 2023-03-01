package com.arcquila.semarangtravel.ui.utils

sealed class UiState<out T: Any?> {
    object Loading : UiState<Nothing>()
    data class Error(val message: String) : UiState<Nothing>()
    data class Success<out T: Any>(val data: T) : UiState<T>()
}