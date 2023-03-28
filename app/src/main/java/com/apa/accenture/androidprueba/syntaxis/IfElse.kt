package com.apa.accenture.androidprueba

fun main(){

}


fun ifMultipleOr(){
    val animal = "dog";
    if(animal == "dog" || animal == "cat") {
        print("es un perrito")
    }
}

fun ifMultiple(){
    var age:Int=18;
    var parentPermission:Boolean= false;
    if(age>=18&&parentPermission){
        print("eleeeeee")
    }

}

fun ifBoolean(){
    var soyFeliz:Boolean = true;
    soyFeliz = !soyFeliz;

    if(!soyFeliz){

    }
}

fun ifAnidado(){
    val animal = "dog";
    if(animal == "dog"){
        print("es un perrito")
    }else if(animal == "gat"){
        print("no es un perrito")
    }else if(animal =="bird"){
        print("no es un pajaro")
    }else{
        print("no es ningun animal")
    }
}

fun ifBasico(){
    val name = "Apa";
    if(name.lowercase() == "Pepe"){
        print("error");
    }else{
        print("hola Apa");
    }
}