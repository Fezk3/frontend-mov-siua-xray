package com.example.uniactivos.viewmodel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.uniactivos.R
import com.example.uniactivos.model.*
import com.example.uniactivos.repository.LoginRepository
import kotlinx.coroutines.*

class LoginViewModel constructor(
    private val loginRepository: LoginRepository,
) : ViewModel(){

    private var job: Job? = null
    private val errorMessage = MutableLiveData<String>()
    private val loading = MutableLiveData<Boolean>()

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResponse = MutableLiveData<LoginResult>()
    val loginResponse : LiveData<LoginResult> = _loginResponse

    fun login(loginRequest: UserLoginInput) {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            loading.postValue(true)
            val response = loginRepository.login(loginRequest)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    _loginResponse.value =
                        LoginResult(success = LoggedInUserView(username = response.body()?.email
                            ?: ""))
                    loading.value = false
                } else {
                    _loginResponse.value = LoginResult(error = R.string.login_failed)
                    onError("Error : ${response.message()}")
                }
            }
        }
    }

    fun logout() {
        loginRepository.logout()
    }

    fun loginDataChanged(loginRequest: UserLoginInput) {
        if (!isUserNameValid(loginRequest.email)) {
            _loginForm.value = LoginFormState(emailError = R.string.invalid_username)
        } else if (!isPasswordValid(loginRequest.password)) {
            _loginForm.value = LoginFormState(
                passwordError = R.string.invalid_password,
                usernameError = R.string.invalid_username
            )
        } else {
            _loginForm.value = LoginFormState(
                isDataValid = true,
                usernameError = R.string.invalid_username
            )
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length >= 5
    }

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}