package com.example.chiamatadirete.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chiamatadirete.data.JokeData
import com.example.chiamatadirete.data.network.JokeRepo
import com.example.chiamatadirete.data.network.JokeService
import kotlinx.coroutines.launch

class JokeViewModel(private val service: JokeService) : ViewModel() {

    val result = MutableLiveData<JokeData?>()

    fun getJoke() {
        viewModelScope.launch {
            var response = service.networkCall()
            if (response.isSuccessful){
                result.postValue(response.body())
            }else{
                Log.e("error","failed to connect")
            }
        }
        }

}

