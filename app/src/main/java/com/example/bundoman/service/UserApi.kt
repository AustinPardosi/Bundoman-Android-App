package com.example.bundoman.service

import com.example.bundoman.models.Token
import com.example.bundoman.models.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("/api/auth/login")
    suspend fun login(@Body userData: User) : Response<Token>
}