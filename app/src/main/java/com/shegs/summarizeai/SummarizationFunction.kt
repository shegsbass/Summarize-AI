package com.shegs.summarizeai

import com.shegs.summarizeai.model.OpenAIRequest
import com.shegs.summarizeai.model.OpenAIResponse
import com.shegs.summarizeai.network.RetrofitClient.openAIApiService
import retrofit2.Call

class SummarizationFunction {
    fun summarizeText(apiKey: String, inputText: String) {
        val request = OpenAIRequest(
            "text-davinci-003",
            "Summarize the following text in 2-4 sentences: $inputText",
            256,
            1,
            1,
            0,
            0
        )
        val call = openAIApiService.summarizeText("Bearer $apiKey", request)

        call.enqueue(
            object : retrofit2.Callback<OpenAIResponse> {
                override fun onResponse(
                    call: Call<OpenAIResponse>,
                    response: retrofit2.Response<OpenAIResponse>
                ) {
                    if (response.isSuccessful) {
                        val summarizedText = response.body()?.choices?.get(0)?.text
                        println("Summarized Text:")
                        println(summarizedText)
                    } else {
                        println("Request failed with status code: ${response.code()}")
                        println("Response body: ${response.errorBody()?.string()}")
                    }
                }

                override fun onFailure(call: Call<OpenAIResponse>, t: Throwable) {
                    println("Request failed: ${t.message}")
                }
            })
    }

}
