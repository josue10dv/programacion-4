package app.practice.movile_app

fun main(){
    println("Operadores logicos")
    val edad: Int = 25
    val entrenamiento: Boolean = true
    val nivel: Int = 8
    val esApto: Boolean = edad >= 18 && entrenamiento && nivel > 5
    val necesitaAyuda: Boolean = !entrenamiento || nivel < 5
    println("Es apto ${esApto}")
    println("Necesita ayuda ${necesitaAyuda}")
}