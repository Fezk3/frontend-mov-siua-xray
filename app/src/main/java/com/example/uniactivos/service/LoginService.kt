package com.example.uniactivos.service

import com.example.uniactivos.model.UserDetails
import com.example.uniactivos.model.UserLoginInput
import com.example.uniactivos.model.UserLoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("/v1/users/login")
    suspend fun login(@Body userLogin: UserLoginInput) : Response<UserLoginResponse> //UserLoginResponse

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