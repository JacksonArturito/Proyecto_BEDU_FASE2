package projectoAmigosCool

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
open class Products (override val name:String): ShopingCart() {
    val list = arrayListOf<Cart>()
    var stock = 20

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

    fun menuCart(nameProduct:String){    /////Menu del Carrito principal
        try{
            println("Cargando menú Carrito....................")
            GlobalScope.launch {
                delay(1000)
            }
            Thread.sleep(5000)
            println("*****************************************************")
            println("Escribe una opción del menu : ")
            println("1) Agregar producto al carrito")
            println("2) Ver Carrito de Compras")
            println("3) Ver Catalogo")
            println("4) Realizar Pago")
            println("5) Regresar al menú principal")
            var number = Integer.valueOf(readLine())

            when(number){
                1 -> {
                    println("Ingresa nombre del Producto")
                    val name = readLine()!!.toString()
                    println("Imgresa la cantidad")
                    var quantity = Integer.valueOf(readLine())
                    addCart(nameProduct,name,quantity)
                }
                2 -> {
                    totalPrice()
                }
                3 -> {
                    val products = Products("Playeras")
                    println("Ingresa nombre del catalogo del Producto")
                    println(" ----------- Playeras -----------------")
                    println(" ----------- Sudaderas -----------------")
                    println(" ----------- Stickers -----------------")
                    println(" ----------- Juegos -----------------")
                    val name = readLine()!!.toString()
                    products.getInventary(name)
                }
                4 -> {
                    val statusPago = PaymentStatus(name)
                    statusPago.statusPayment()
                }
                5 -> main()
                else -> println("Opción no valida")
            }
        } catch (e: NumberFormatException){
            println("Por favor, escribe una opción válida")
        }

    }

    override fun addCart(name: String,description:String,quantity: Int) {   ///Función para agregar productos al mercado
        when(name){
            "Playeras" -> {
                val price = t_Shirts[description]!!.toLong()
                list.add(Cart(description,price,quantity,(price*quantity)))
                menuCart(name)
            }
            "Sudaderas" ->{
                val price = sweatshirts[description]!!.toLong()
                list.add(Cart(description,price,quantity,(price*quantity)))
                menuCart(name)
            }
            "Stickers" ->{
                val price = stickers[description]!!.toLong()
                list.add(Cart(description,price,quantity,(price*quantity)))
                menuCart(name)
            }
            "Juegos"->{
                val price = coolsGames[description]!!.toLong()
                list.add(Cart(description,price,quantity,(price*quantity)))
                menuCart(name)
            }

            else -> println("Producto no encontrado en el inventario")
        }
    }

    override fun totalPrice() {       ////////Función total de Pago
        val totalPrice = quotePrice()
        if (totalPrice == 0.0){
            println("El carrito de compras esta vacio :(")
            menuCart(name)
        }else{
            for (producto in list){
                val detailBuy = """ Nombre                 Cantidad                          Precio
 ${producto.name}             ${producto.quantity}                          ${producto.price}  
                                                          Subtotal : ${producto.priceTotal}"""
                println(detailBuy)
            }
            if (totalPrice >= 999){        //Valida si el Pago total es mayor ó igual 900
                println("ENVIO GRATIS en todas las compras mayores a $999")  //Si es mayor ó igual a 900 el costo de envio es gratis
                println("Total de compra:  $totalPrice")
                menuCart(name)
            }else{
                println("Total de compra más costo de envio de $150 es : ${totalPrice+150}") //Si es menor a 900 se cobra el costo de envio a $150.MXN
                menuCart(name)
            }
        }
    }

    override fun quotePrice(): Double {   //Función que muestra los productos en el carrito
        if (list.isEmpty()){      //// Realiza una validacion si el carrito esta vacio
           return 0.0
        }else{
            for (producto in list){
                return producto.priceTotal.toDouble()  ///Regresa el Precio Total del Carrito si este contiene productos
            }
        }
        return 0.0 ///Regresa 0.0 si el carrito esta vacio
    }

    fun getInventary(name: String){    //Función para mostrar los productos de la tienda
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


