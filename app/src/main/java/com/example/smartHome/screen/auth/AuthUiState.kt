package com.example.smartHome.screen.auth

import javax.annotation.concurrent.Immutable

@Immutable
data class AuthUiState(
    val errorMessage: String? = null,
    val isError: Boolean = false,
    val email: String = "",
    val password: String = "",
) {
    companion object {
        val Empty = AuthUiState()
    }
}

sealed class AuthUiEvent {
    class OnTypeEmail(val email: String) : AuthUiEvent()
    class OnTypePassword(val password: String) : AuthUiEvent()
    object OnSignIn : AuthUiEvent()
    object OnSingUp: AuthUiEvent()
}

sealed class AuthUiEffect {
    object NavigateToSignInScreen : AuthUiEffect()
    object NavigateToSignUpScreen : AuthUiEffect()
}