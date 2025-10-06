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
    var tipoDriode: String = "C-3PO"
    when (tipoDriode){
        "R2-D2", "R2-Q5" -> println("Droide atromecanico")
        "C-3PO", "C-3PA" -> println("Droide de protocolo")
        "BB8-8", "BB-9E" -> println("Droide de nueva generacion")
        else -> println("Modelo desconocido")
    }

    var luzSemaforo: String = "verde"
    var estado: String = "vacia"
    when {
        luzSemaforo == "verde" && estado == "vacia" -> println("Avanzar")
        luzSemaforo =="amarillo" && estado == "vacia" -> println("Precaucion")
        luzSemaforo == "rojo" && estado == "Con trafico" -> println("Esperar")
        else -> println("Estado no reconocido")
    }

}