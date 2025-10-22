package app.practice.movile_app

fun main(){
    println("Variables")
    val planeta = "Tatooine" // Constante
    var jedi = "Anekin" // Vairable

    jedi = "Oviwan"
    println("Tipos de variables")
    println("====================")
    println("Tipos numericos")
    val edad: Int = 25
    println("Int " + edad)
    val altura: Double = 25.5
    println("Double " + altura)
    val peso: Float = 25.5f
    println("Float " + peso)
    val nombre: String = "Obi-Wan Kenobi"
    println("String " + nombre)
    val inical: Char  = 'O'
    println("Char " + peso)
    val esJedi: Boolean  = true
    println("Boolean " + esJedi)
    val apellido: String? = null
    println("Nullable " + apellido)
    val ciudad: String? = ""
    println("Nullable " + ciudad?.length)
    println("====================")
    println("Operaciones")
    val longitudSegura = ciudad!!.length
    println("Asercion no null " + longitudSegura)
    println("${nombre.uppercase()} nacio en ${planeta}")
    println("En 10 años tendra ${edad + 10}")
    var mensaje = """
        Querido $nombre
        Tu mision en $planeta
        ha sido completamente exitosa
        que la fuerza te acompañe
    """
    println("String multilinea " + mensaje)
    println("====================")
    println("Conversiones")
    val textoEdad: String = "25"
    val edadConvertida: Int = textoEdad.toInt()
    println("Edad convertida de texto a entero " + edadConvertida)
    val numero: Double = 50.5
    val numeroConvertido: String = numero.toString()
    println("Numero convertida de doble a texto " + numeroConvertido)



}

