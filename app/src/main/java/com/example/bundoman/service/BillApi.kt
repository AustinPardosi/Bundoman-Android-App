package com.example.bundoman.service

import com.example.bundoman.models.RootItemList
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface BillApi {
    @Multipart
    @POST("/api/bill/upload")
    suspend fun sendBill(@Header("Authorization") token: String, @Part imgFile : MultipartBody.Part) : Response<RootItemList>
}