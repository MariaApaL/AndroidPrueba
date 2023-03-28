package com.apa.accenture.androidprueba

fun main(){
    var weekDays = arrayOf("Lunes","Martes","Miércoles","Jueves","Viernes","Sábado","Domingo")
    println(weekDays) //Te da la posicion de memoria

    println(weekDays[0]);

    println(weekDays.size)

    if(weekDays.size>=8){
    println(weekDays[7])
    }else{
        println("Ya no hay más")
    }

    weekDays[0]="Monday" // cambia el valor


    //Bucles para arrays
    for(position in weekDays.indices){
        println(weekDays[position])
    }

    for((position,value)in weekDays.withIndex()){
        println("La posicion $position, contiene $value")
    }

    for(weekDay in weekDays){
        println("Ahora es $weekDay")
    }
}