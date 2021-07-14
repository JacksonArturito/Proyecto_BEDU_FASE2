package PostWorks.s8



import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

const val CARD_LENGHT = 16

fun main(): Unit = runBlocking{
    measureTimeMillis1 {
        val cardStatus = async { cardValidated() }
        println("¿Pago Aceptado? ${cardStatus.await()}")
    }
}

inline fun measureTimeMillis1(block: () -> Unit){
    val start = System.currentTimeMillis()
    block()
    val end = System.currentTimeMillis() - start
    println("Tiempo transcurrido: ${end/1_000L} segundos")
}

suspend fun cardValidated():Boolean {
    println("Ingrese Num de Tarjeta para Efectuar la compra: ")
    val numTarjeta = readLine()!!.toLong()
    println("Validando Tarjeta, espere un momento...")
    delay(2000)

    if (numTarjeta.toString().length == CARD_LENGHT) {
        println("Tarjeta Valida")
        return true
    }
    println("Tarjeta Invalida")
    return false
}