package com.apa.accenture.androidprueba

fun main(){

    //? significa que puede ser nulo
    var name:String? = null;

    //!! !! Significa que estoy seguro de que no es null
    println(name!![3]!!)
    println(name.get(3)) //es lo mismo
    //Si esto no es nulo.. dame esta posicion (devuelve null si es null)
    println(name?.get(3))
    //Si esto no es nulo, dame esta posicion, si no, dame x
    println(name?.get(3) ?: "Es nulo")
}