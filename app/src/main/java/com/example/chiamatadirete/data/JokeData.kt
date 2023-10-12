package com.example.chiamatadirete.data
import com.google.gson.annotations.SerializedName

//PRIMA COSA DA FARE : CREARE UNA DATA CLASS IN CUI INCOllALRE IL JSON DELL'API USANDO ALT+ K

data class JokeData(
    @SerializedName("punchline")
    val punchline: String?,
    @SerializedName("setup")
    val setup: String?,

)