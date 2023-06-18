package com.example.uniactivos.service

import com.example.uniactivos.model.UserDetails
import com.example.uniactivos.model.UserLoginInput
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

class LoginService {

    /*

    @POST("/v1/users/login")
    suspend fun login(): Response<UserDetails>

     */

    companion object {
        private var loginService : LoginService? = null
        fun getInstance() : LoginService {
            if (loginService == null) {
                loginService = ServiceBuilder.buildService(LoginService::class.java)
            }
            return loginService!!
        }
    }
}