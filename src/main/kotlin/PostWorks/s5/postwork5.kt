package PostWorks.s5


fun main(){

    class carrito(val producto:String, val descripcion:String, val precio: Int)

    println("Estos  son los artículos de tu carrito: ")

    val producto1 = carrito("ALV", "...", 150)
    println(producto1.producto)
    println(producto1.descripcion)
    println(producto1.precio)
    println("-------------------------")

    val producto2 = carrito("Amigos cool", "...", 290)
    println(producto2.producto)
    println(producto2.descripcion)
    println(producto2.precio)
    println("-------------------------")

    val producto3 = carrito("Juego", "...", 750)
    println(producto3.producto)
    println(producto3.descripcion)
    println(producto3.precio)
    println("-------------------------")

    val producto4 = carrito("Cafecito", "...", 199)
    println(producto2.producto)
    println(producto2.descripcion)
    println(producto2.precio)
    println("-------------------------")

    val producto5 = carrito("Juego", "...", 349)
    println(producto3.producto)
    println(producto3.descripcion)
    println(producto3.precio)
    println("-------------------------")


    val precioProductos = listOf(producto3.precio,producto1.precio, producto2.precio,
        producto4.precio, producto5.precio)

    println("Estos son los precios de tus productos que podrían incluir un descuento:\n " +
            "$precioProductos")


    val (nodescuento, descuento) = precioProductos.partition { it > 300 }
    println("\nPrecios de tus productos que incluyen descuento: $descuento")
    println("\nPrecios de tus productos que NO incluyen descuento: $nodescuento")

    val promocion = precioProductos.map { if (it >= 300) it else it - 100 }
    println("\nPrecio final de tus productos aplicando el descuento: $promocion")
    println("*** Si alguno de tus precios no cambia, es porque el producto no incluia descuento **")


}


