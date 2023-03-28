package com.apa.accenture.androidprueba

fun main() {

}

//No recomendado usar Any
fun result(value:Any){
    when(value){
        is Int -> value + value
        is String -> print(value)
        is Boolean -> if(value) print("hey")

    }
}

fun getSemester(month:Int){
   return when (month) {
        //para rangos de números
        in 1..6 -> print("Primer Semestre")
        7 -> print("Domingo")
        !in 1..7->print("Error")
        else->print("bye")
    }
//   var result= when (month) {
//        //para rangos de números
//        in 1..6 -> print("Primer Semestre")
//        7 -> print("Domingo")
//        !in 1..7->print("Error")
//       else->print("bye")
//    }
//    return result
}

fun getTrimester2(month: Int)= when(month){
    1, 2, 3 -> print("Primer Trimestre")
    4,5,6  -> print("Segundo TRimestre")
    7 -> print("Domingo")
    else -> println("Error")
}

fun getTrimester(month:Int){
    when (month) {
        1, 2, 3 -> print("Primer Trimestre")
        4,5,6  -> print("Segundo TRimestre")
        7 -> print("Domingo")
        else -> println("Error")
    }
}

fun getDay(day: Int) {
//    if(day==1){
//        print("Lunes")
//    }else if(day==2){
//        print("Martes")
//    }else if(day==3){
//        print("Miércoles")
//    }else if(day==4){
//        print("Jueves")
//    }else if(day==5){
//        print("Viernes")
//    }else if(day==6){
//        print("Sábado")
//    }else if(day==7){
//        print("Domingo")
//    }
    when (day) {
        1 -> print("Lunes")
        2 -> print("Martes")
        3 -> ("Miércoles")
        4 -> print("Jueves")
        5 -> {
            print("Viernes")
            print("Fiesta")
        }
        6 -> print("Sábado")
        7 -> print("Domingo")
        else -> println("Error")
    }

}