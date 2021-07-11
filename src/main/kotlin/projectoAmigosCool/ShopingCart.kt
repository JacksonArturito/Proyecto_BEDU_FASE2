package projectoAmigosCool

abstract class ShopingCart {
    abstract val name: String
    abstract val quantity: Int

    abstract fun quotePrice(total :Double)
    abstract fun addCart(name: String,description:String,quantity: Int):Double

}