package projectoAmigosCool

abstract class ShopingCart {
    abstract val name: String

    protected var paid = false
    protected var paidAmount = 0.0

    protected val tutarjeta = "Tarjeta"
    protected val transferecia = "Transferencia"
    protected val tarjetaP = "Puntos"
    open val tarjeta = 5000f
    protected val puntos = "La cantidad de puntos que puede abonar son $50, $100 y $500"

    abstract fun quotePrice():Double
    abstract fun addCart(name: String,description:String,quantity: Int)
    abstract fun totalPrice()

}