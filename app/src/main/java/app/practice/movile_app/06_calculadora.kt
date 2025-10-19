package app.practice.movile_app

fun main(){
    println("Operadores aritmeticos")
    println("Introduce el primer valor")
    val value1: Int = readLine()?.toIntOrNull()?:0
    println("Introduce el segundo valor")
    val value2: Int = readLine()?.toIntOrNull()?:0
    println("suma: ${value1+ value2} ")
    println("Resta: ${value1 - value2} ")
    println("Multiplicacion: ${value1 * value2} ")
    println("Division: ${value1 / value2} ")

}