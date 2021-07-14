package PostWorks.s6



class SweatShirths (precio: Float, modelo: String,
                    numPedido: String): Producto(precio,
    modelo, numPedido) {
    override fun getTotalPrice(total: Int): Float {
        return this.precio*total
    }
}