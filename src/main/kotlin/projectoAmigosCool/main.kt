package projectoAmigosCool

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


fun main() {
    val loginUser = LoginUser()
    println("!Hola Bienvenido a la Tienda de Amigos Cool")
    println("Cargando menú principal....................")
    GlobalScope.launch {
        delay(1000)
    }
    Thread.sleep(3000)

    try{
        println("Escribe una opción del menu : ")  ///Menu principal de la aplicación
        println("1) Iniciar sesion")
        println("2) Registrarse")
        println("3) Consultar Productos")

        var number = Integer.valueOf(readLine())

        when(number){
            1 -> loginUser.login()
            2 -> loginUser.registerUser()
            3 -> {
                val products = Products("Playeras")
                println("Ingresa nombre del cataogo del Producto")
                println(" ----------- Playeras -----------------")
                println(" ----------- Sudaderas -----------------")
                println(" ----------- Stickers -----------------")
                println(" ----------- Juegos -----------------")
                val name = readLine()!!.toString()
                products.getInventary(name)
            }
            else -> println("Opción no valida")
        }
    } catch (e: NumberFormatException){
        println("Por favor, escribe una opción válida")
    }


}