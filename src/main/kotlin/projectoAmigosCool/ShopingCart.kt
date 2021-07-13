package projectoAmigosCool

abstract class ShopingCart {
    abstract val name: String

    protected var paid = false
    protected var paidAmount = 0.0

    abstract fun quotePrice():Double
    abstract fun addCart(name: String,description:String,quantity: Int)
    abstract fun totalPrice()

}