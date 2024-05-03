package com.example.bundoman.repository

import com.example.bundoman.models.RootItemList
import com.example.bundoman.service.BillApi
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import java.io.File

class BillRepo(private val billReq: BillApi) {
    suspend fun sendBill(token : String, imgFile : File) : Response<RootItemList> {
        val reqFile : RequestBody = RequestBody.create(MediaType.parse("image/*"), imgFile)
        val file : MultipartBody.Part = MultipartBody.Part.createFormData("file", imgFile.name, reqFile)
        return billReq.sendBill("Bearer $token", file)
    }
}