package app.practice.movile_app

fun main(){
    println("Bucles")
    val jedis = listOf("Luke", "Leia", "Obi-Wan", "Yoda", "Ahsoka")
    for ((index, jedi) in jedis.withIndex()) {
        println("${index + 1}. ${jedi}")
    }
    //rango ascendentes
    for (i in 0..20 step 2) {
        println("Energia: $i%")
    }
    //rango descendentes
    for (countdown in 10 downTo 1) {
        println("Despegue en: $countdown")
    }
    //control de flujo
    for (jedi in jedis){
        if( jedi == "Obi-Wan") continue
        if( jedi == "Yoda") break
        println("Entrenado a ${jedi}")
    }

}