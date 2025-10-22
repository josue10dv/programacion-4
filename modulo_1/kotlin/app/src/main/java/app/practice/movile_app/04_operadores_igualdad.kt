package app.practice.movile_app

fun main(){
    println("Operadores aritmeticos")
    val nombre_1: String = "Yoda"
    val nombre_2: String = "Yoda"
    val nombre_3: String = String("Yoda".toCharArray())
    println("Igualdad estructural (contenido)")
    println(nombre_1==nombre_2)
    println(nombre_1==nombre_3)
    println("Igualdad estructural (misma instancia)")
    println(nombre_1===nombre_2)
    println(nombre_1===nombre_3)

}