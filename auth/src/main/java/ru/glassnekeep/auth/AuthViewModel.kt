package ru.glassnekeep.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.glassnekeep.user_data.models.User
import javax.inject.Inject

class AuthViewModel @Inject constructor(
    private val registerUserUseCase: RegisterUserUseCase
): ViewModel() {
    sealed class AuthState {
        object Loading: AuthState()
        object Success: AuthState()
        data class Error(val message: String): AuthState()
    }

    private var _state = MutableStateFlow<AuthState>(AuthState.Loading)
    val state = _state.asStateFlow()
    val handler = CoroutineExceptionHandler { _, exception ->
        Log.e(ERROR_TAG, exception.message ?: ERROR_MSG)
        _state.value = AuthState.Error(ERROR_MSG)
    }

    fun register(user: User) {
        viewModelScope.launch(handler) {
            registerUserUseCase.execute(user)
        }.invokeOnCompletion {
            _state.value = AuthState.Success
        }
    }

    companion object {
        const val ERROR_MSG = "Error registering user"
        const val ERROR_TAG = "REGISTER_ERROR"
    }
}