package app.practice.movile_app

fun main() {
    println("Mapas")

    val fuerzaJedis = mapOf<String, Int>(
        "Luke" to 85,
        "Leia" to 88,
        "Obi-Wan" to 95,
        "Yoda" to 199
    )
    println("Fuerza de los Jedis: ${fuerzaJedis}")

    val misionesCompletas = mutableMapOf<String, Int>()
    misionesCompletas["Luke"] = 15
    misionesCompletas["Leia"] = 12
    misionesCompletas.put("Obi-Wan", 29)

    println("Misiones: ${misionesCompletas}")

    for ((jedi, fuerza) in fuerzaJedis){
        println("${jedi} tiene un nivel de fuerza {$fuerza}")
    }

    val planetasVisitados = listOf<String>("Tatooine", "Coruscant", "Degobah")
    println("Planetas visitados: ${planetasVisitados}")

    val planetasPeligrosos = listOf<String>("Mustafar", "Coruscant", "Korriban")
    println("Planetas peligrosos: ${planetasPeligrosos}")

    println("Operaciones con conjuntos")
    val interseccion = planetasVisitados intersect planetasPeligrosos
    val union = planetasVisitados union planetasPeligrosos
    val diferencia = planetasVisitados - planetasPeligrosos
    println("Planetas visitados y peligrosos: ${interseccion}")
    println("Todos los planetas: ${union}")
    println("Planetas seguros visitados: ${diferencia}")





}