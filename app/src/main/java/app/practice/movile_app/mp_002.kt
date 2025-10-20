package app.practice.movile_app

/**
 * ========================
 * Tema: Aplicacion de reservas para un hotel
 * ========================
 **/

/**
 * ========================
 * Ejemplos de Mapas
 * ========================
 */
// Mapa inmutable de tarifas por tipo de habitacion
val rates_by_room_type = mapOf<String, Double>(
    "Standard" to 100.0,
    "Deluxe" to 150.0,
    "Suite" to 250.0,
    "Presidential" to 500.0
)

// Mapa mutable de servicios adicionales
val additional_services = mutableMapOf<String, Double>()

// Funcion para agregar servicios adicionales
fun add_service(name: String, price: Double) {
    additional_services[name] = price
}

// Funcion para calcular el costo total de servicios
fun calculate_services_cost(): Double {
    var total = 0.0
    for ((service, price) in additional_services) {
        total += price
    }
    return total
}

// Funcion para obtener la tarifa de una habitacion
fun get_room_rate(type: String): Double? {
    return rates_by_room_type[type]
}

/**
 * ========================
 * Ejemplos de Listas
 * ========================
 */
// Lista inmutable de servicios del hotel
val available_services: List<String> = listOf(
    "WiFi",
    "Piscina",
    "Gimnasio",
    "Spa",
    "Restaurante",
    "Servicio a la habitacion"
)

// Lista mutable de huespedes actuales
val current_guests: MutableList<String> = mutableListOf()

// Funcion para registrar un huesped
fun register_guest(name: String) {
    current_guests.add(name)
    println("Huesped ${name} registrado exitosamente")
}

// Funcion para dar de baja un huesped
fun check_out_guest(name: String) {
    current_guests.remove(name)
    println("El huesped ${name} ha registrado su salida")
}

// Funcion para buscar huesped por iniciales
fun find_guest_by_initial(initial: String): String? {
    return current_guests.find { it.startsWith(initial) }
}

// Funcion para verificar si hay huespedes
fun has_guests(): Boolean {
    return current_guests.isNotEmpty()
}

// Funcion para ordenar huespedes alfabeticamente
fun get_sorted_guests(): List<String> {
    return current_guests.sorted()
}

/**
 * ========================
 * Ejemplos de Funciones
 * ========================
 */
// Funcion simple sin parametros
fun show_welcome() {
    println("Bienvenido al hotel La Caldera")
}

// Funcion con parametros y retorno
fun calculate_stay(days: Int, daily_rate: Double): Double {
    return days * daily_rate
}

// Funcion de expresion
fun apply_discount(total: Double, discount: Double) = total * (1 - discount / 100)

// Funcion con retorno multiple
fun calculate_total_cost(days: Int, daily_rate: Double, services: Double): Pair<Double, Double> {
    val room_cost = days * daily_rate
    val total_cost = room_cost + services
    return Pair(room_cost, total_cost)
}

// Funcion lambda para calcular descuento VIP
val calculate_vip_discount = { total: Double -> total * 0.85 }

// Funcion lambda para generar codigo de reserva
val generate_reservation_code = { name: String, room: String -> 
    "RES-${name.uppercase()}-${room.uppercase()}-10132025"
}

/**
 * ========================
 * Ejemplos de POO - Data Classes
 * ========================
 */
data class Reservation(
    val reservation_code: String,
    val guest_name: String,
    val room_type: String,
    val number_of_nights: Int,
    val check_in_date: String,
    val is_vip: Boolean = false
) {
    // Propiedad calculada para el costo base
    val base_cost: Double
        get() = (rates_by_room_type[room_type] ?: 0.0) * number_of_nights
    
    // Propiedad calculada para el costo final con descuento VIP
    val final_cost: Double
        get() = if (is_vip) base_cost * 0.85 else base_cost
    
    // Metodo para verificar si es una estadia larga
    fun is_long_stay(): Boolean = number_of_nights >= 7
    
    // Metodo para calcular puntos de lealtad
    fun calculate_loyalty_points(): Int {
        val points_per_night = 10
        val vip_bonus = if (is_vip) 50 else 0
        val long_stay_bonus = if (is_long_stay()) 100 else 0
        return (number_of_nights * points_per_night) + vip_bonus + long_stay_bonus
    }
}

/**
 * ========================
 * Ejemplos de POO - Enum Classes
 * ========================
 */
enum class RoomStatus(
    val description: String,
    val color_code: String
) {
    AVAILABLE("Habitacion disponible para reserva", "VERDE") {
        override fun can_reserve() = true
        override fun message() = "Esta habitacion esta lista para ser reservada"
    },
    OCCUPIED("Habitacion actualmente ocupada", "ROJO") {
        override fun can_reserve() = false
        override fun message() = "Esta habitacion esta ocupada"
    },
    MAINTENANCE("Habitacion en mantenimiento", "NARANJA") {
        override fun can_reserve() = false
        override fun message() = "Esta habitacion esta en mantenimiento"
    },
    CLEANING("Habitacion en proceso de limpieza", "AMARILLO") {
        override fun can_reserve() = false
        override fun message() = "Esta habitacion esta siendo limpiada"
    };
    
    abstract fun can_reserve(): Boolean
    abstract fun message(): String
    
    companion object {
        fun by_description(desc: String) = values().find { 
            it.description.contains(desc) 
        }
    }
}

class Room(
    val number: Int,
    val type: String,
    var status: RoomStatus
) {
    fun change_status(new_status: RoomStatus) {
        status = new_status
        println("Habitacion ${number} en estado: ${status.message()}")
    }
    
    fun information() = """
        Habitacion #${number}
        Tipo: ${type}
        Estado: ${status.description}
        ${status.message()}
        Valor: $${rates_by_room_type[type]} por noche
    """.trimIndent()
}

/**
 * ========================
 * Ejemplos de Excepciones Personalizadas
 * ========================
 */
class RoomNotAvailableException(room: Int) : 
    Exception("Habitacion ${room} no disponible para reservacion")

class CapacityExceededException(capacity: Int, requested: Int) : 
    Exception("Capacidad excedida. Maximo: ${capacity}, cantidad solicitada: ${requested}")

class PastDateException(date: String) : 
    Exception("La fecha ${date} no esta disponible. Seleccione una fecha futura")

class InsufficientPaymentException(required: Double, received: Double) : 
    Exception("Saldo insuficiente. Valor: $${required}, saldo actual: $${received}")

/**
 * ========================
 * Ejemplos de Manejo de Excepciones
 * ========================
 */
fun process_reservation(
    room_number: Int,
    number_of_people: Int,
    amount: Double,
    total_cost: Double
): String {
    return try {
        // Simulacion de validaciones
        val room_available = room_number % 2 == 0
        val max_capacity = 4
        
        when {
            !room_available -> 
                throw RoomNotAvailableException(room_number)
            number_of_people > max_capacity -> 
                throw CapacityExceededException(max_capacity, number_of_people)
            amount < total_cost -> 
                throw InsufficientPaymentException(total_cost, amount)
            else -> 
                "Reserva procesada exitosamente para la habitacion ${room_number}"
        }
    } catch (e: RoomNotAvailableException) {
        "Error: ${e.message}. Seleccione otro cuarto"
    } catch (e: CapacityExceededException) {
        "Error: ${e.message}. Considere reservar multiples habitaciones"
    } catch (e: InsufficientPaymentException) {
        "Error: ${e.message}. Use otro metodo de pago para continuar"
    } catch (e: Exception) {
        "Error inesperado: ${e.message}"
    } finally {
        println("Reservacion procesada exitosamente")
    }
}

fun validate_reservation_date(date: String): String {
    return try {
        // Simulacion: si la fecha contiene "2024", es pasada
        if (date.contains("2024")) {
            throw PastDateException(date)
        }
        "Fecha valida: ${date}"
    } catch (e: PastDateException) {
        "Error: ${e.message}"
    }
}

/**
 * ========================
 * Funcion Principal de Demostracion
 * ========================
 */
fun main() {
    println("========================")
    println("SISTEMA DE RESERVAS DEL HOTEL")
    println("========================")
    
    // Ejemplos de Mapas
    println("--- Mapas ---")
    println("Valor por habitacion Deluxe: $${get_room_rate("Deluxe")}")
    add_service("Spa", 50.0)
    add_service("Breakfast", 25.0)
    add_service("Transfer", 30.0)
    println("Valor por servicios adicionales: $${calculate_services_cost()}")
    
    // Ejemplos de Listas
    println("--- Listas ---")
    register_guest("Erick Toapanta")
    register_guest("Michelle Torres")
    register_guest("Fran Alvarez")
    println("Cantidad de huespedes actuales: ${current_guests}")
    println("Busca huespedes con letra 'M' incial en su nombre: ${find_guest_by_initial("M")}")
    println("Lista de huespedes ordenada: ${get_sorted_guests()}")
    
    // Ejemplos de Funciones
    println("--- Funciones ---")
    show_welcome()
    val stay_cost = calculate_stay(5, 150.0)
    println("Valor por 5 noches: $${stay_cost}")
    println("Valor aplicando el 10% de descuento: $${apply_discount(stay_cost, 10.0)}")
    val (room_cost, total_cost) = calculate_total_cost(5, 150.0, 105.0)
    println("Valor de la habitacion: $${room_cost}, valor total: $${total_cost}")
    println("Descuento VIP aplicado: $${calculate_vip_discount(total_cost)}")
    println("Codigo de reservacion: ${generate_reservation_code("John Smith", "Deluxe")}")
    
    // Ejemplos de POO
    println("--- OOP ---")
    val reservation1 = Reservation(
        "RES-001",
        "Nathaly Toapanta",
        "Deluxe",
        5,
        "2025-11-01",
        false
    )
    println(reservation1)
    println("Valor base: $${reservation1.base_cost}")
    println("Valor final: $${reservation1.final_cost}")
    println("Puntos recibidos: ${reservation1.calculate_loyalty_points()}")
    
    val vip_reservation = reservation1.copy(is_vip = true, number_of_nights = 10)
    println("Reservacion VIP:")
    println("Descuento total: $${vip_reservation.final_cost}")
    println("Puntos recibidos: ${vip_reservation.calculate_loyalty_points()}")
    
    // Ejemplos de Enum
    println("--- ENUM ---")
    val room101 = Room(101, "Deluxe", RoomStatus.AVAILABLE)
    println(room101.information())
    println("Actualizando estado...")
    room101.change_status(RoomStatus.OCCUPIED)
    
    val room102 = Room(102, "Suite", RoomStatus.MAINTENANCE)
    println("${room102.information()}")
    
    // Ejemplos de Excepciones
    println("--- Excepciones ---")
    println(process_reservation(101, 3, 500.0, 450.0))
    println(process_reservation(102, 3, 500.0, 450.0))
    println(process_reservation(104, 6, 500.0, 450.0))
    println(process_reservation(106, 2, 300.0, 450.0))
    
    println("--- Excepciones personalizadas ---")
    println(validate_reservation_date("2024-12-25"))
    println(validate_reservation_date("2025-12-25"))
    
}

