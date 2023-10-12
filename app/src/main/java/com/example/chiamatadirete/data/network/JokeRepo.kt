package com.example.chiamatadirete.data.network

import com.example.chiamatadirete.data.JokeData
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object JokeRepo {

    var jokeService: JokeService? = null

    suspend fun getJoke(): Response<JokeData>? {
        if (jokeService == null) {
            jokeService = createRetrofitInstance().create(JokeService::class.java)
        }
        return jokeService?.networkCall()
    }

    fun createRetrofitInstance(): Retrofit {
        val baseUrl = "https://official-joke-api.appspot.com/jokes/"
        val httpClient = OkHttpClient.Builder().build()
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}