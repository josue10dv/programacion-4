package app.practice.movile_app

fun main(){
    val values_1: Int = 5
    val values_2: Int = 7
    if(values_1 > values_2){
        println("El mayor es ${values_1}")
    }else{
        println("El mayor es ${values_2}")
    }
    var fuerza: Int = 10
    if(fuerza > 10){
        println("Maestro")
    }else if (fuerza > 5){
        println("Caballero Jedi")
    }else{
        println("Padawan")
    }
}