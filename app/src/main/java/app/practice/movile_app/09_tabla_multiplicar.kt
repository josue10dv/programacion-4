package app.practice.movile_app


fun main(){
    println("Introduce el primer valor")
    val value1: Int = readLine()?.toIntOrNull()?:0
    println("Introduce el segundo valor")
    val value2: Int = readLine()?.toIntOrNull()?:0
    println("Introduce la operacion a realizar")
    val signo: String= readLine()?:""
    when{
        signo == "+" -> println(value1+value2)
        signo == "-" -> println(value1-value2)
        signo == "*" -> println(value1*value2)
        signo == "/" -> println(value1/value2)
        else -> println("ingrese el signo correctamente")
    }


}