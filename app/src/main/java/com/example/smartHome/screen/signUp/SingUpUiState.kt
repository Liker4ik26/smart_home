package com.example.smartHome.screen.signUp

import javax.annotation.concurrent.Immutable

@Immutable
data class SingUpUiState(
    val errorMessage: String? = null,
    val isError: Boolean = false,
    val email: String = "",
    val password: String = "",
    val username: String = "",
) {
    companion object {
        val Empty = SingUpUiState()
    }
}

sealed class SingUpUiEvent {
    class OnTypeEmail(val email: String) : SingUpUiEvent()
    class OnTypePassword(val password: String) : SingUpUiEvent()
    class OnTypeUsername(val username: String) : SingUpUiEvent()
    object OnSingUp : SingUpUiEvent()
    object OnSingIn : SingUpUiEvent()
}

sealed class SingUpUiEffect {
    object NavigateToPinCodeScreen : SingUpUiEffect()
    object NavigateToSignInScreen : SingUpUiEffect()
}