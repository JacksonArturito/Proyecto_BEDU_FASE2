package projectoAmigosCool

val list = arrayListOf<Cart>()

open class Products (override val name:String): ShopingCart() {

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
    fun menuCart(nameProduct:String){
        try{
            println("Escribe una opción del menu : ")
            println("1) Agregar producto al carrito")
            println("2) Realizar pago")
            println("3) Consultar Productos")
            println("4) Cancelar Pago")
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
                2 -> {
                    quotePrice()
                }
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
                4 -> {
                    val pagoCancelado = PaymentStatus(name)
                    pagoCancelado.cancelPayment();
                }
                else -> println("Opción no valida")
            }
        } catch (e: NumberFormatException){
            println("Por favor, escribe una opción válida")
        }

    }

    override fun addCart(name: String,description:String,quantity: Int) {
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
    override fun quotePrice(){
       if (list.isEmpty()){
           println("El carrito de compras esta vacio :(")
       }else{
           for (producto in list){
               val detailBuy = """ Nombre                 Cantidad                          Precio
 ${producto.name}             ${producto.quantity}                          ${producto.price}  
                                                          Total : ${producto.priceTotal}"""
               println(detailBuy)
           }
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


