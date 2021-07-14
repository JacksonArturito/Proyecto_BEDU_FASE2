package PostWorks.s6



import java.text.SimpleDateFormat
import java.util.Date

fun main() {
    val now = Date()
    val formatDate = SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz")
    println("Fecha de compra: ${formatDate.format(now)}")

    val sweatS = SweatShirths(456f,"AMIGOS COOL CARTOON",  "3478")
    println("Producto: ${sweatS.modelo}")
    println("Precio: ${sweatS.precio}")
    println("Numero de pedido: ${sweatS.numPedido}")
    println("Total a pagar: $ ${sweatS.getTotalPrice(2)}")
}