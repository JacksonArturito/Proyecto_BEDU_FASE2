package projectoAmigosCool

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PaymentStatus (name: String) : Products(name),StatusPayment{

    val total = quotePrice()

    override fun statusPayment() {   ///Función para cancelar pago
        println("Desea continuar con el pago ingrese si pa continuar y no para cancelar")
        val statusPayment = readLine()!!.toString()
        if(statusPayment.equals("si")){
            makePayment()
        }else{
            cancelPayment()
        }

    }

    override fun cancelPayment() {
            paid=false
            paidAmount=0.0
            println("Pago cancelado exitosamente!")
            println("Desea regresar al menú principal Si ó No")
            val optCMenu = readLine()!!.toString()

        if(optCMenu.equals("Si")){
            main()
        }else{
           println("Gracias por su visita (˘︹˘)")
        }
    }

    override fun makePayment() {
        println("¿Quieres proceder con el pago?")

        val respuesta = readLine().toString()

        when {
            respuesta == "si" -> {
                println("\nCargando métodos de pago...")

                GlobalScope.launch {
                    delay(1000)
                }
                Thread.sleep(1000)

                println("\nLos métodos de pago son:")
                println(tutarjeta)
                println(transferecia)
                println(tarjetaP)
                println("Elige el método de pago:")

                val pago = readLine().toString()

                if (pago == "Tarjeta") {
                    //println("Elegiste pago con tarjeta")

                    println("\nNo cierre su pantalla, estamos procesando el pago...")
                    GlobalScope.launch {
                        delay(1000)
                    }
                    Thread.sleep(2000)

                    if (total >= tarjeta) {
                        println("\nSu saldo es insuficiente y no se puede completar el pago :c")
                    } else if (total <= tarjeta) {
                        println("\nSu saldo es suficiente, !Compra exitosa! :D")
                    }

                } else if (pago == "Transferencia") {

                    //println("Elegiste pago mediante transferencia")

                    println("\nCargando datos de la transferencia...")
                    GlobalScope.launch {
                        delay(1000)
                    }
                    Thread.sleep(2000)

                    println(
                        "\nLos datos para realizar la transferencia son:\n" +
                                "Banco: BBVA\n" +
                                "Número de cuenta: 123456789034578321\n" +
                                "Referecia: 612348\n" +
                                "Monto a pagar: $$total MX")

                } else if (pago == "Puntos") {
                    //println("Elegiste pago con puntos Amigos cool")

                    println("\nNo cierre su pantalla, estamos calculando sus puntos...")
                    GlobalScope.launch {
                        delay(1000)
                    }
                    Thread.sleep(1000)

                    if (total >= tarjeta) {
                        println("\nSus puntos son insuficientes.¿Desea agregar más puntos?")
                        val respuestaP = readLine().toString()
                        if (respuestaP == "si") {
                            println(puntos)
                            println("Escriba la cantidad de puntos que quiera abonar:")
                            val agregarP = readLine()?.toInt()
                            if (agregarP == 50) {
                                println("Tenías $tarjeta puntos, ahora tienes ${tarjeta + 50}")
                                println("Total a pagar: $total")
                                println("El pago se ha realizado automaticamente")
                                println("Puntos actuales: ${tarjeta + 50 - total}")
                                println("Gracias por tu compra :D")
                            } else if (agregarP == 100) {
                                println("Tenías $tarjeta puntos, ahora tienes ${tarjeta + 100}")
                                println("Total a pagar: $total")
                                println("El pago se ha realizado automaticamente")
                                println("Puntos actuales: ${tarjeta + 100 - total}")
                                println("Gracias por tu compra :D")
                            } else if (agregarP == 500) {
                                println("Tenías $tarjeta puntos, ahora tienes ${tarjeta + 500}")
                                println("Total a pagar: $total")
                                println("El pago se ha realizado automaticamente")
                                println("Puntos actuales: ${tarjeta + 500 - total}")
                                println("Gracias por tu compra :D")
                            } else {
                                println("\nNo se puede abonar esa cantidad en puntos, por favor elija una cantidad válida")
                            }
                        } else {
                            println("¿Deseas seguir comprando?")
                            val seguircomprando = readLine().toString()
                            if (seguircomprando == "si") {
                                main()
                            }
                        }
                    } else if (total <= tarjeta) {
                        println("\nSus puntos son suficiente, !Compra exitosa! :D")
                    }

                } else if (pago != "Tarjeta" || pago != "Transferencia" || pago != "Puntos") {
                    println("Ingrese un método de pago válido")

                }
            }
            else -> {
                println("¿Deseas seguir comprando?")
                val seguircomprando = readLine().toString()
                if (seguircomprando == "si") {
                    main()
                } else if (seguircomprando == "no"){
                    println("¿Segur@ que no?")
                    println("podemos ofrecerte paquetes exclusivos que desearás comprar! :D")

                }
            }
        }
    }
}