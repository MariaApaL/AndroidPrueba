package com.apa.accenture.androidprueba


//Variables
fun main() {



}


fun variableBoolean(){
    //Boolean
    val boolean: Boolean = true;

    print(boolean);
    //println salto de línea


    //Para convertir a int:
    //var suma:Int = age + comas.toInt()
    //Para sumar strings con numeros:
    //println(string1.toInt() + string2.toInt())
    //Para convertir a string
    //double.toString();

    //FUNCIONES


    //stringConcatenada = "Hola me llamo $string"
}
fun variablesAlfanumericas() {
    //Variables alfanuméricos

    //Char , SOLO 1 Comillas simples
    val char: Char = 'e';

    //string comillas dobles.
    val string: String = "Apa";


}

fun variablesNumericas() {

    //val es constante
    //var es una variable
    //Int
    val age: Int = 9;
    //val age:Int = adhajdh (error)


    //

    //long PARA ENORMES
    //val example:Long =

    //float 6 decimales
    val comas: Float = 30.5f;

    // double 12 decimales
    val double: Double = 345.2345;

}

fun showMyAge(currentAge: Int) {
    println("Tengo $currentAge años");
}
//Valor por defecto, si no ponemos nada imprime 30
fun showMyAge2(currentAge: Int=30) {
    println("Tengo $currentAge años");
}
fun showMyName(name:String){
    println("Mi nombre es $name");
}

//Get:
fun resta(firstNumber:Int, secondNumber:Int):Int{
    return firstNumber + secondNumber;
}

//Pa ponerlo bonito si es simple:
fun ejemplo(firstNumber: Int, secondNumber: Int) = firstNumber - secondNumber;