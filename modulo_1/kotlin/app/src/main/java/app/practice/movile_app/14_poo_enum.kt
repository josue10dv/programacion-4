package app.practice.movile_app

enum class TipoSable(
    val color: String,
    val poder: Int
){
    AZUL("azul", 85){
        override fun descripcion() = "Sable tradicional de los Jedi"
    },
    VERDE("verde", 90){
        override fun descripcion() = "Sable de los Jedi consultores"
    },
    ROJO("rojo", 95){
        override fun descripcion() = "Sable de los Sith"
    },
    MORADO("morado", 99){
        override fun descripcion() = "Sable que equilibra luz y oscuridad"
    };

    abstract fun descripcion(): String
    companion object {
        fun porColor(color: String) = values().find { it.color == color }
    }
}

class SableDeLuz(
    val tipo: TipoSable,
    val portador: String
){
    fun activar() = "Zrum! El sable color ${tipo.color} de ${portador} se enciende"
    fun info() = "${tipo.descripcion()} - tipo poder ${tipo.poder}"
}

fun main(){
    val SableWindoo = SableDeLuz(TipoSable.MORADO, "Windoo")
    println(SableWindoo)
    println(SableWindoo.activar())
    println(SableWindoo.info())

    val SableLuke = SableDeLuz(TipoSable.VERDE, "Luke Skywalker")
    println(SableLuke)
    println(SableLuke.activar())
    println(SableLuke.info())
}