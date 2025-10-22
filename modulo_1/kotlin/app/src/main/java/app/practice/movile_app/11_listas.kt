package app.practice.movile_app

fun main(){
    println("Listas")
    val inmutable: List<Int> = listOf(1,2,3)
    println("Lista inmutable de numeros ${inmutable}")

    val mutable: MutableList<Int> = mutableListOf(4,5,6)
    println("Lista mutable de numeros ${mutable}")
    mutable.add(7)
    println("Lista mutada de numeros (agregacion) ${mutable}")
    mutable.removeAt(0)
    println("Lista mutada de numeros (eliminacion) ${mutable}")

    for(element in mutable) println(element)

    println("Operaciones con listas")

    var colores: MutableList<String> = mutableListOf<String>("rojo", "verde")
    colores.add("azul")
    colores +="amarillo"
    colores.add(1,"blanco")
    println(colores)
    colores.remove("verde")
    colores[0] = "negro"
    println(colores)
    colores.clear()
    println(colores.isEmpty())

    println("Busqueda con mutable list")
    val nombres = mutableListOf<String>("Juan", "Luis", "Pedro")
    println(nombres.find{it.startsWith("L")})
    println(nombres.firstOrNull{it.length>4})
    println(nombres.any{it.contains('J')})
    println(nombres.none{it == "x"})

    println("Ordenamiento con mutable list")
    val numerosDesordenados: MutableList<Int> = mutableListOf(9,4,7,1,0,8,6)
    println(numerosDesordenados.sorted())
    println(numerosDesordenados.sortedDescending())
    println(numerosDesordenados.distinct())

}