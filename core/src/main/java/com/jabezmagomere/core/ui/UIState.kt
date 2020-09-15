package com.jabezmagomere.core.ui

sealed class UIState {
    object Loading : UIState()
    data class Error(val exception: Exception) : UIState()
    data class Success(val isSuccess: Boolean) : UIState()
}
