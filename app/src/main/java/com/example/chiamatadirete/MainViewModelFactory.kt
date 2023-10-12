package com.example.chiamatadirete

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chiamatadirete.data.network.JokeService
import com.example.chiamatadirete.ui.JokeViewModel
import java.lang.IllegalArgumentException

class MainViewModelFactory(private val service: JokeService): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if( modelClass.isAssignableFrom(JokeViewModel::class.java)){
            return JokeViewModel(service) as T
        }else{
            throw IllegalArgumentException("ViewModel not assignable from")
        }
    }
}