package com.example.bundoman.service

import com.example.bundoman.models.TokenExpInfo
import retrofit2.Response
import retrofit2.http.Header
import retrofit2.http.POST

interface TokenApi {
    @POST("/api/auth/token")
    suspend fun checkTokenExp(@Header("Authorization") token: String) : Response<TokenExpInfo>
}