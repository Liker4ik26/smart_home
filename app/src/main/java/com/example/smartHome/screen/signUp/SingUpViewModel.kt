package com.example.smartHome.screen.signUp

import android.util.Log
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
class SingUpViewModel @Inject constructor(
    private val authorizationRepository: AuthenticationRepository
) : ViewModel() {
    private val _state = MutableStateFlow(SingUpUiState.Empty)
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<SingUpUiEffect>()
    val effect = _effect.asSharedFlow()

    fun sendEvent(event: SingUpUiEvent) {
        when (event) {
            is SingUpUiEvent.OnTypeEmail -> {
                _state.update { it.copy(email = event.email) }
            }

            is SingUpUiEvent.OnTypePassword -> {
                _state.update { it.copy(password = event.password) }
            }

            is SingUpUiEvent.OnTypeUsername -> {
                _state.update { it.copy(username = event.username) }
            }

            is SingUpUiEvent.OnSingIn -> {
                viewModelScope.launch { _effect.emit(SingUpUiEffect.NavigateToSignInScreen) }
            }

            is SingUpUiEvent.OnSingUp -> {
                viewModelScope.launch {
                    val result = authorizationRepository.signUp(
                        email = _state.value.email,
                        password = _state.value.password,
                    )

                    Log.d("resAuth", result.toString())

                    authorizationRepository.addUser(
                        username = _state.value.username,
                    )

                    _effect.emit(SingUpUiEffect.NavigateToPinCodeScreen)
                }
            }
        }
    }
}
