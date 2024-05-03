package com.example.bundoman.repository

import com.example.bundoman.models.TokenExpInfo
import com.example.bundoman.service.TokenApi
import retrofit2.Response

class TokenRepo(private val tokenReq: TokenApi) {
    suspend fun checkTokenExp(token : String) : Response<TokenExpInfo>{
        return tokenReq.checkTokenExp("Bearer $token")
    }
}