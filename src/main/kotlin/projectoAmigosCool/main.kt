package projectoAmigosCool

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    val loginUser = LoginUser()
    var estado = false
    do {
        println("Bienvenido a Amigos Cool")
        var status = loginUser.login(estado)
        GlobalScope.launch {
            delay(1000)
        }
        Thread.sleep(3000)

        if (status) {
            println("Cargando menú principal....................")
            try {
                println("Escribe una opción del menu : ") //Menu principal de la aplicación
                println("1) Registrarse")
                println("2) Ver Catalogo")
                println("3) Salir")

                var number = Integer.valueOf(readLine())

                when (number) {
                    1 -> loginUser.registerUser()
                    2 -> {
                        val products = Products("Playeras")
                        println("Ingresa nombre del cataogo del Producto")
                        println(" ----------- Playeras -----------------")
                        println(" ----------- Sudaderas -----------------")
                        println(" ----------- Stickers -----------------")
                        println(" ----------- Juegos -----------------")
                        val name = readLine()!!.toString()
                        products.getInventary(name)
                    }
                    3 -> break
                    else -> println("Opción no valida")
                }
            } catch (e: NumberFormatException) {
                println("Por favor, escribe una opción válida")
            }
        } else {
            println("No se Ingreseo a la plataforma")
        }
        println("¿Regresar al inicio? (s/n)")
        var cont = readLine()!!.toString()
    }while (cont == "s")
    println("¡Regresa Pronto!")
}