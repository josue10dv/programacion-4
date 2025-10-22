package app.practice.movile_app

data class Jedi(
    val nombre: String,
    val edad: Int,
    val nivelFuerza: Int,
    val maestro: String?= null,
){
    val rango: String
        get() = when {
            nivelFuerza >= 99 -> "Maestro"
            nivelFuerza >= 79 -> "Caballero"
            nivelFuerza >= 59 -> "Padawan"
            else -> {
                "Iniciado"
            }
        }

    fun puedeEnseniar(): Boolean = nivelFuerza >= 70

    fun entrenar(): Boolean = edad <= 5
}

fun main(){
    val Luke: Jedi = Jedi(
        "Anakin Skywalker",
        25,
        75,
        "Obiwan Kenobi"
    )
    println(Luke)
    // Descentralizacion de un objeto
    val(nombre, edad, nivelFuerza) = Luke
    println("Nombre del Jedi ${nombre}, edad ${edad}, nivel de fuerza ${nivelFuerza}")
    // Crea una copia del objeto
    val Ashoka = Luke.copy(nombre="Ashoka",nivelFuerza = 80)
    println("Rango de Ashoka ${Ashoka.rango}")
    println("Ashoka puede enseniar ${Ashoka.puedeEnseniar()}")
}