package com.alex.gimenes.portaladventureapp.common.state

sealed class State<out T> {
    data class Success<T>(val data: T) : State<T>()
    data class Error(val error: Throwable) : State<Nothing>()
    data class Loading(val isLoading: Boolean) : State<Nothing>()
    data object Inactive : State<Nothing>()
}