package app.practice.movile_app

import java.util.Objects

/**
 * ========================
 * Tema: Aplicacion de reservas para un hotel
 * ========================
 **/

/**
 * ========================
 * Ejemplos de variables
 * ========================
 */
// Variables de fecha
var fecha_entrada: String = "2025-10-05 12:45:00"
var fecha_salida: String = "2025-10-15 12:00:00"

// Variables de control
var cantidad_personas: Int = 4
var tipo_habitacion: String = "Deluxe"

/**
 * ========================
 * Ejemplos de condicionales y de igualdad
 * ========================
 */
// Valida el estado de una habitacion
fun validate_available_room(state: String): Boolean {
    return state == "available"
}

// Valida su la reservacion pertenece a un tour
fun validate_is_tour(reservation_type: String): Boolean {
    return reservation_type == "Tour"
}

/**
 * Ejemplos de operadores aritmeticos
 */
// Obtiene la cantidad de platos se requiere en el comedor
fun get_dish_amount(): Int {
    val current_people: Int = 15
    val REQUIRED_PLATE_PER_PERSON: Int = 3 // Cantidad de platos por persona
    return current_people * REQUIRED_PLATE_PER_PERSON
}

// Obtiene la cantidad de platos se requiere en el comedor
fun get_reservation_total(): Float {
    val room_fee: Float = 16.78f
    val total_nights: Float = 4.00f
    val spent: Float = 254.47f
    return room_fee + total_nights + spent
}

/**
 * Ejemplos de condicionales
 */
// Obtiene el piso de la habitacion reservada
fun get_floor_number(reservation_type: String): String{
    when {
        reservation_type == "Deluxe" -> return "4to piso"
        reservation_type == "Premium" -> return "3er piso"
        reservation_type == "Regular" -> return "2do piso"
        else -> return "No determinado"
    }
}

// Obtiene el piso de la habitacion reservada
fun get_scheduled_activity(current_hour: Int): String{
    when {
        current_hour == 1 -> return "Torneo de Ping pong"
        current_hour == 2 -> return "Karaoke"
        current_hour == 3 -> return "Caminata guiada"
        else -> return "Sin actividad designada"
    }
}

/**
 * Ejemplos de bucles
 */
// Imprime el saludo de bienvenida
fun print_welcome_quote(){
    val incoming_people: List<String> = listOf("Luke", "Rory", "Lorelay", "Michelle", "Erick")
    for ((index, guests) in incoming_people.withIndex()) {
        println("Hola ${guests}, bienvenido al hotel La caldera, es un gusto servirte")
    }
}

// Imprime opciones de desayunos
fun print_breakfast_menu() {
    val breakfast_options: List<String> = listOf<String>("Continental","Montuvio","Serrano")
    for ((index, breakfast) in breakfast_options.withIndex()) {
        println("${index}. ${breakfast}")
    }
}







