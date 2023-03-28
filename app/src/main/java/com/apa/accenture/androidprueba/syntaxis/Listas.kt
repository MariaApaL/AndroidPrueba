package com.apa.accenture.androidprueba

fun main(){


}

fun inmutableList(){
    val readOnly:List<String> = listOf("Lunes","Martes","Miércoles","Jueves","Viernes","Sábado","Domingo")
    println(readOnly.size)
    //println(readOnly.toString) y println(readOnly) es lo mismo
    println(readOnly)
    println(readOnly[0])
    println(readOnly.last())
    println(readOnly.first())

    //Filtrar
    val example = readOnly.filter{ it.contains("a")}
    println(example)

    //Iterar
    readOnly.forEach{ weekday -> println(weekday)}
}

fun mutableList(){
    var weekDays:MutableList<String> = mutableListOf("Lunes","Martes","Miércoles","Jueves","Viernes","Sábado","Domingo")
    println(weekDays)
    weekDays.add("ApaDay")
    weekDays.add(0,"LedoDay") //añades en una posición exacta

    if(weekDays.isEmpty()){

    }else{
        weekDays.forEach{println(it)}
    }

    if(weekDays.isNotEmpty()){
        weekDays.forEach{println(it)}
    }

}