package com.example.bundoman.repository

import com.example.bundoman.models.Token
import com.example.bundoman.models.User
import com.example.bundoman.service.UserApi
import retrofit2.Response

class UserRepo(private val userReq: UserApi) {
    suspend fun getLoginToken(userData : User) : Response<Token>{
        return userReq.login(userData)
    }
}