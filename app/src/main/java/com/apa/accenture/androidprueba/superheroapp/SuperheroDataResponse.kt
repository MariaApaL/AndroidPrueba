package com.apa.accenture.androidprueba.superheroapp

import com.google.gson.annotations.SerializedName

//Si quiero cmabiar el nombre de la variable sin que afecte al parametro del json que recogemos
//Usamos @SerializedName("nombredelparamtro) val nombrequequiera
//Se recomienda usar siempre el serialized aunque usemos el mismo nombre

data class SuperheroDataResponse(
    @SerializedName("response") val response: String,
    @SerializedName("results") val superheroes: List<SuperheroItemResponse>
)

data class SuperheroItemResponse(
    @SerializedName("id") val superheroId: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val superheroImage:SuperheroImageResponse
)

data class SuperheroImageResponse(
    @SerializedName("url") val url:String)