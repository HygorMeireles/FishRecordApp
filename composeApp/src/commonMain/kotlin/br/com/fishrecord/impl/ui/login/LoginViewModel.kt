package br.com.fishrecord.impl.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fishrecord.common.manager.SessionManager
import br.com.fishrecord.common.result.ResponseResult
import br.com.fishrecord.impl.data.datasource.model.User
import br.com.fishrecord.impl.data.repository.FishRecordRepository
import br.com.fishrecord.impl.domain.usecase.DoLoginUseCase
import br.com.fishrecord.impl.domain.usecase.DoLoginUseCaseParams
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val doLoginUseCase: DoLoginUseCase
): ViewModel() {

    private val _loginState: MutableStateFlow<LoginViewState> = MutableStateFlow(LoginViewState.Initial)
    val loginState: StateFlow<LoginViewState> get() = _loginState

    fun login(login: String, password: String) {
        _loginState.tryEmit(LoginViewState.Loading)
        viewModelScope.launch {
            when (val result = doLoginUseCase.invoke(DoLoginUseCaseParams(login, password))) {
                is ResponseResult.Success -> result.data.run {
                    SessionManager.user = this
                    _loginState.tryEmit(
                        LoginViewState.Authenticated(this)
                    )
                }

                is ResponseResult.Error -> _loginState.tryEmit(
                    LoginViewState.Error(
                        msg = result.resultError.msg
                    )
                )
            }
        }
    }
}

sealed class LoginViewState() {
    data object Initial : LoginViewState()
    data object Loading : LoginViewState()
    data class Error(val msg: String) : LoginViewState()
    data class Authenticated(val user: User) : LoginViewState()
}