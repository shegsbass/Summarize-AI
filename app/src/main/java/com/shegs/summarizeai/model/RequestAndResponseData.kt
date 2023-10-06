package com.shegs.summarizeai.model

data class OpenAIRequest(
    val model: String,
    val prompt: String,
    val max_tokens: Int,
    val temperature: Int,
    val top_p: Int,
    val frequency_penalty: Int,
    val presence_penalty: Int
)

data class OpenAIResponse(val choices: List<Choice>)

data class Choice(val text: String)