package app.practice.movile_app

fun main(){
    /**
     * 1. Semaforo peatonal
     */
    println("============================")
    println("Ingrese el color del semaforo (verde/amarillo/rojo): ")
    var color: String = (readLine()?:"").trim().lowercase()
    println("Presiono el boton (si/no)")
    var is_pressed: String = (readLine()?:"").trim().lowercase()

    when {
        color == "verde" && is_pressed == "si" -> println("Espera a rojo")
        color == "rojo" -> println("Cruza")
        color == "amarillo" -> println("Preparate")
        else -> println("Espera")
    }
    println("============================")
    /**
     * 2. Entrada de cine con descuento
     */
    var ticket: Double = 5.00
    println("Ingresa tu edad: ")
    var age: Int = readLine()?.toIntOrNull()?:0

    when{
        age < 12 -> ticket = 3.00
        age > 65 -> ticket = 4.00
        else -> ticket = 5.00
    }
    println("El precio del ticket para los $age anios es: $ticket")

    /**
     * 3. Contador de pares hasta N
     */
    println("============================")
    println("Ingresa N para el contador de pares: ")
    var n: Int = readLine()?.toIntOrNull()?:1
    var even_amount: Int = 0
    for (i in 1..n){
        if(i % 2 == 0){
            println("El numero $i es par")
            even_amount += 1
        }
    }
    println("La cantidad de pares hasta $n es $even_amount")

    /**
     * 4. Suma de multiplos de 3 hasta N
     */
    println("============================")
    println("Ingresa N para la suma de multiplos de 3: ")
    n = readLine()?.toIntOrNull()?:1
    var three_multiplies: Int = 0
    for (i in 1..n){
        if (i % 3 == 0) three_multiplies++
    }
    println("La cantidad de multiplos de 3 hasta $n es: $three_multiplies")

    /**
     * 5. Estado del agua por temperatura
     */
    println("============================")
    println("Ingresa la temperatura: ")
    val temperature: Int = readLine()?.toIntOrNull()?:0
    if (temperature in 1..99){
        println("Liguido")
    }else if (temperature > 99){
        println("Gas")
    }else{
        println("Solido")
    }

    /**
     * 6. Calculadora minima
     */
    println("============================")
    var option: String = ""
    var a: Double? = null
    var b: Double? = null
    while(option != "0"){
        println(
            """
            Menu :3
            1) Suma
            2) Resta
            0) Salir
            """.trimIndent()
        )
        option = (readLine()?:"").lowercase()
        println("Ingrese el numero 1:")
        a = readLine()?.toDoubleOrNull()?:0.00
        println("Ingrese el numero 2:")
        b = readLine()?.toDoubleOrNull()?:0.00
        when(option){
            "1" -> println("$a + $b = ${a + b}")
            "2" -> println("$a + $b = ${a - b}")
            else -> println("Opcion invalida")
        }
    }

    /**
     * 7. Validador de contraseña
     */
    println("============================")
    println("Ingresa tu contrasenia: ")
    val password: String = (readLine()?:"").lowercase()
    if (password.length < 8){
        println("La contrasenia es debil")
    }

    /**
     * 8. Contar vocales en una palabra
     */
    val vocals: MutableMap<Char, Int> = mutableMapOf<Char, Int>(
        'a' to 0,
        'e' to 0,
        'i' to 0,
        'o' to 0,
        'u' to 0,
    )
    println("============================")
    println("Ingresa la palabra para contar la cantidad de vocales: ")
    val word: String = (readLine()?:"").lowercase()
    for(digit in word){
        if(digit in vocals){
            vocals[digit] = (vocals[digit]?:0) + 1
        }
    }
    println("Cantidad de vocales en $word = $vocals")

    /**
     * 9. Tabla de multiplicar para un numero x
     */
    println("============================")
    println("Ingresa el numero para obtener su tabla de multiplicar: ")
    val x: Int = readLine()?.toIntOrNull()?:1
    for(i in 1..10){
        println("$i * $x = ${i * x}")
    }

    /**
     * 10. Promedio y aprobacion
     */
    println("============================")
    var total_great: Double = 0.0
    for(i in 1..3){
        println("Ingrese la nota sobre 10")
        total_great += readLine()?.toDoubleOrNull()?:0.0
    }
    println("El promedio de las notas es: ${total_great / 3}")

}