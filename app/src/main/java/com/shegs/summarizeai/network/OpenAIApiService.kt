package com.shegs.summarizeai.network

import com.shegs.summarizeai.model.OpenAIRequest
import com.shegs.summarizeai.model.OpenAIResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface OpenAIApiService {
    @POST("v1/completions")
    fun summarizeText(
        @Header("Authorization") apiKey: String,
        @Body request: OpenAIRequest
    ): Call<OpenAIResponse>
}