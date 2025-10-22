package app.practice.movile_app

class FuerzaInsuficienteException(message: String) : Exception(message)
class MisionPeligrosaException(nivelPeligro: Int, message: String) : Exception(message)

fun realizarMision(
    nivelFuerza: Int,
    peligroMision: Int,
): String {
    return try {
      when {
          nivelFuerza < 30 -> throw FuerzaInsuficienteException("Nivel de fuerza muy bajo: ${nivelFuerza}")
          nivelFuerza > 30 -> throw MisionPeligrosaException(peligroMision, "Mision extremadamente peligrosa")
          else -> {"Error inseperado"}
      }
    } catch (e: FuerzaInsuficienteException){
        "error: ${e.message}. Se requiere entrenamiento adicional"
    } catch (e: MisionPeligrosaException){
        "error: ${e.message}. Nivel de peligro: ${peligroMision}"
    } catch (e: Exception){
        "${e.message}"
    } finally {
        "Reporte Enviado"
    }
}

fun main(){
    println(realizarMision(20,69))
    println(realizarMision(100,69))
}
