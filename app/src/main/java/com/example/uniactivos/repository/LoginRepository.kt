package com.example.uniactivos.repository

import com.example.uniactivos.model.UserDetails
import com.example.uniactivos.model.UserLoginInput
import com.example.uniactivos.model.UserLoginResponse
import com.example.uniactivos.service.LoginService
import com.example.uniactivos.utils.MyApplication.Companion.sessionManager
import retrofit2.Response

class LoginRepository constructor (
    private val loginService: LoginService
){

    // in-memory cache of the loggedInUser object
    private var user: UserDetails? = null

    val isLoggedIn: Boolean
        get() = user != null

    init {
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
        user = null
    }

    fun logout() {
        user = null
        sessionManager?.deleteAuthToken()
    }

    suspend fun login(userLogin: UserLoginInput)  : Response<UserDetails> { //UserLoginResponse
        val response = loginService.login(userLogin)

        if (response.isSuccessful) {
            setLoggedInUser(response.body(), response.headers()["Authorization"].toString())
        }

        return response
    }

    private fun setLoggedInUser(loginRequest: UserDetails?, token:String) {
        this.user = loginRequest
        sessionManager?.saveAuthToken(token)

        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }
}