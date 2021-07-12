package projectoAmigosCool

abstract class ShopingCart {
    abstract val name: String

    protected var paid = false
    protected var paidAmount = 0

    abstract fun quotePrice()
    abstract fun addCart(name: String,description:String,quantity: Int)

}