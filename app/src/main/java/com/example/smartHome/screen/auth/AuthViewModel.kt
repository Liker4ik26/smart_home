package com.example.smartHome.screen.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartHome.supabase.authorization.data.remote.AuthenticationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authorizationRepository: AuthenticationRepository
) : ViewModel() {
    private val _state = MutableStateFlow(AuthUiState.Empty)
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<AuthUiEffect>()
    val effect = _effect.asSharedFlow()

    fun sendEvent(event: AuthUiEvent) {
        when (event) {
            is AuthUiEvent.OnTypeEmail -> {
                _state.update { it.copy(email = event.email) }
            }

            is AuthUiEvent.OnTypePassword -> {
                _state.update { it.copy(password = event.password) }
            }

            is AuthUiEvent.OnSingUp -> {
                viewModelScope.launch { _effect.emit(AuthUiEffect.NavigateToSignUpScreen) }
            }

            is AuthUiEvent.OnSignIn-> {
                viewModelScope.launch {
                    viewModelScope.launch {
                        authorizationRepository.signIn(
                            email = _state.value.email,
                            password = _state.value.password,
                        )
                    }
                    _effect.emit(AuthUiEffect.NavigateToSignInScreen)
                }
            }
        }
    }
}