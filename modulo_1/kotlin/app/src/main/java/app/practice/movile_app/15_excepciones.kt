package app.practice.movile_app

fun main(){
    try {
        val resultado = 8/0
    }catch (e: Exception){
        println(e)
        println("Error en la division")
    }
}