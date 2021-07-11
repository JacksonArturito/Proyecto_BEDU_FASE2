package projectoAmigosCool

import kotlinx.coroutines.processNextEventInCurrentThread
import java.util.ArrayList

class Products (override val name:String, override val quantity:Int): ShopingCart() {

    val t_Shirts = mapOf(
        "Abrázame Classic" to 256.0,
        "Las Quesadillas Llevan Queso" to 256.0,
        "EN VISTO BLANC" to 256.0,
        "FEO PERO BUEN PEDO" to 256.0,
        "ALV ORIGINAL" to 256.0,
        "COOL NETWORK" to 256.0,
        "AMIGOS HUB" to 256.0,
        "Simple White" to 256.0,
        "PEZ ESPADA" to 256.0,
        "TIGRE AMARILLO" to 256.0,
        "TIGRE AMARILLO" to 256.0,
        "BANANA" to 256.0,
        "Make Mexico Emo Again" to 256.0)

    val sweatshirts = mapOf(
        "ABRÁZAME MORADO" to 456.0,
        "SUD Make Mexico Emo Again" to 456.0,
        "ARRE MORADA" to 456.0,
        "AMIGOS COOL CARTOON" to 456.0)

    val stickers = mapOf(
        "MAKING WAVES STICKER" to 25.0,
        "CHILL STICKER" to 25.0,
        "EL WONG STICKER" to 25.0,
        "COOL COLA STICKER" to 25.0,
        "X HUESS STICKER GOLD" to 25.0,
        "Cool Network STICKER" to 25.0)

    val coolsGames = mapOf(
        "YO NUNCA NUNCA" to 179.0,
        "Agua de Calzón" to 179.0,
        "NO INVENTES El Juego" to 179.0)

    override fun quotePrice(total: Double) {
        TODO("Not yet implemented")
    }

    override fun addCart(name: String,description:String,quantity: Int):Double {
        when(name){
            "Playeras" -> {
                val price = t_Shirts[description]
            }
            "Sudaderas" ->{
                val price = sweatshirts[description]
                println(price)
            }
            "Stickers" ->{
                val price = stickers[description]
                println(price)
            }
            "Juegos"->{
                val price = coolsGames[description]
                println(price)
            }

            else -> println("Producto no encontrado en el inventario")
        }

        return 23.4
    }
    fun menuCart(nameProduct:String){
        try{
            println("Escribe una opción del menu : ")
            println("1) Agregar prodcuto al carrito")
            println("2) Ver Carrito de COmpras")
            println("3) Consultar Productos")
            var number = Integer.valueOf(readLine())

            when(number){
                1 -> {
                    println("Ingresa nombre del Producto")
                    val name = readLine()!!.toString()
                    println("Imgresa la cantidad")
                    var quantity = Integer.valueOf(readLine())
                    println("Catalogo de clientes $nameProduct")
                   addCart(nameProduct,name,quantity)
                }
                2 -> println("Ver Carrito")
                3 -> println("Consultar Productos")
                else -> println("Opción no valida")
            }
        } catch (e: NumberFormatException){
            println("Por favor, escribe una opción válida")
        }

    }


    fun getInventary(name: String){
        when(name){
            "Playeras" ->{
                println("---------------Playeras Amigos Cool-------------------")
                println("Nombre          ------------>   Precio")
                for (t_shirt in t_Shirts){
                    println("${t_shirt.key} ------------> $ ${t_shirt.value}")
                }
                menuCart(name)
            }
            "Sudaderas" ->{
                println("---------------Sudaderas Amigos Cool-------------------")
                println("Nombre          ------------>   Precio")
                for (sweatshirt in sweatshirts){
                    println("${sweatshirt.key} ------------> $ ${sweatshirt.value}")
                }
                menuCart(name)
            }
            "Stickers" ->{
                println("---------------Stickers Amigos Cool-------------------")
                println("Nombre          ------------>   Precio")
                for (sticker in stickers){
                    println("${sticker.key} ------------> $ ${sticker.value}")
                }
                menuCart(name)
            }
            "Juegos"->{
                println("---------------Juegos Amigos Cool-------------------")
                println("Nombre          ------------>   Precio")
                for (coolsGame in coolsGames){
                    println("${coolsGame.key} ------------> $ ${coolsGame.value}")
                }
                menuCart(name)
            }
            else -> println("Producto no encontrado en el inventario")
        }
    }


}
