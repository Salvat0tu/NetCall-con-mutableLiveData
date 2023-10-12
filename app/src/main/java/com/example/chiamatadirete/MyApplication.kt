package com.example.chiamatadirete

import android.app.Application
import com.example.chiamatadirete.data.network.JokeProvider

class MyApplication: Application() {
    private val provider = JokeProvider().provide()
    val viewModelFactory = MainViewModelFactory(provider)

override fun onCreate(){
    super.onCreate()
}
}