package com.example.chiamatadirete.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

//TODO: CREIAMO LA CLASSE ViewModel CHE CONTIENE TUTTE LE LOGICHE NON STRETTAMENTE LEGATE AD ANDROID
// ES: ALL'INIZIO INSTANZIO IL VALORE RESULT CHE E' UNA MutableLiveData DI JokeData
// (UN MutableLiveData PUO' ESSERE OSSERVATO E POSSIAMO QUINDI SPECIFICARE DEL CODICE CHE VERRA' ESEGUITO)
// OGNI VOLTA CHE IL VALORE DEL MutableLiveData CAMBIA)

//TODO: CREIAMO UNA FUNZIONE DOVE ESEGUIAMO IL CODICE.
// TRAMITE COROUTINE CREIAMO UN VALORE CHIAMATO RESPONSE E GLI DICIAMO CHE E' UGUALE ALLA FUNZIONE 'getJoke()'
// CHE ABBIAMO CREATO DENTRO ALL'OBJECT. DI FATTO CORRISPONDE ALLA 'RISPOSTA' DELLE CHIAMATE DI RETE.
// POI DICIAMO ALLA FUNZIONE, SE QUESTA 'RESPONSE' (CHE POTREBBE ESSERE NULL)
// HA AVUTO SUCCESSO (TRAMITE IL METODO isSuccessful) IMPOSTA IL VALORE DI 'result'
// A CIO' CHE E' STATO SPECIFICATO NELL'INTERFACCIA (TRAMITE IL METODO 'postValue'

// TODO: (IN QUESTO CASO ABBIAMO DETTO IN SINTESI, VAI NELL'URL 'https://official-joke-api.appspot.com/jokes/' E PRENDI IL CONTENUTO
//  NELLA SEZIONE 'random'

//TODO: COME? result.postValue(response.body())
// 'result' = MutableLiveData (dei dati che abbiamo inserito)
// USIAMO 'postValue' PERCHE' IL VALORE DI UNA MutableLiveData PUO' ESSERE CAMBIATO SOLO NEL THREAD UI
// QUINDI, QUANDO LO CAMBIAMO IN ALTRI THREAD USIAMO postValue
// NELLE PARENTESI SPECIFICHIAMO CHE IL VALORE E' IL ''CORPO'' DELLA RISPOSTA CHE RICEVIAMO DALLA CHIAMATA
// IL CORPO SAREBBE QUELLO CHE ABBIAMO SPECIFICATO NELL'INTERFACCIA


//TODO: METTIAMO UN ELSE IN CASO CI SIANO ERRORI

class JokeViewModel : ViewModel() {

    val result = MutableLiveData<JokeData?>()

    fun getJoke() {
        viewModelScope.launch(IO) {
            var response = JokeRepo.getJoke()
            if (response?.isSuccessful == true) {
                result.postValue(response.body())
            } else {
                Log.e("NETWORK ERROR", "Failed to connect")
            }
        }
    }
}

