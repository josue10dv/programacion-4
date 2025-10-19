package app.practice.movile_app

fun saludar(){
    println("Hola desde una funcion")
}

fun sumar(a: Int, b: Int): Int{
    return a + b
}

fun cuadrado(numero: Int) = numero * numero

fun retornoMultiple(a: Int, b: Int): Pair<Int, Int>{
    return Pair(a + b, a - b)
}

fun main(){
    saludar()
    println(sumar(5, 6))
    println(cuadrado(2))
    print(retornoMultiple(7,15))
    // Funciones lambda
    val cuadradoLambda = {x: Int -> x * x}
    val saludoLambda = {nombre: String -> "Wenos dias {$nombre}"}
    println(cuadradoLambda(2))
    print(saludoLambda("Erick"))


}