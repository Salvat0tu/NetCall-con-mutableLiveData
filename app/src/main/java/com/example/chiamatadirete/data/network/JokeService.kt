package com.example.chiamatadirete.data.network

import com.example.chiamatadirete.data.JokeData
import retrofit2.Response
import retrofit2.http.GET

//COME SECONDA COSA CREARE UN INTERFACE DOVE METTERE UN "GET" DOVE INSERIRE LA PARTE DEL URL DOPO LO SLASH ESEMPIO
//Http:pipupapu.com/random

interface JokeService {

    @GET("random")
    suspend fun  networkCall(): Response<JokeData>
}