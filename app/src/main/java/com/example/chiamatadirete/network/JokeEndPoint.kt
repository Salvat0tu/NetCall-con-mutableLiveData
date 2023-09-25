package com.example.chiamatadirete.network

import retrofit2.Response
import retrofit2.http.GET

//COME SECONDA COSA CREARE UN INTERFACE DOVE METTERE UN "GET" DOVE INSERIRE LA PARTE DEL URL DOPO LO SLASH ESEMPIO
//Http:pipupapu.com/random

interface JokeEndPoint {

    @GET("random")
    suspend fun  networkCall(): Response<JokeData>
}