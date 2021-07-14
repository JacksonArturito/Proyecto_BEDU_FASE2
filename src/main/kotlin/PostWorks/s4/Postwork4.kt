package PostWorks.s4


fun main(){
    //Ingresando Informacion en Data Class
    println("Producto en Inventario: ")
    val producto1 = Stickers("Sticker", "X HUESS STICKER GOLD",
        2, 150, 25.50f)
    println(producto1)

    println("Cliente Registrado: ")
    val cliente = Cliente("Clara", "Gonzales", "Montes",
        "claraGM@correo.com", 5520983421L,
        "Av. Canarias 150. San Juan, 09020, CDMX", "Frecuente")
    cliente.mostrarInformacion()

    val productos = Products("Juego", "YO NUNCA NUNCA",
        3, 50, 179f)
    productos.InfoProducto()

    val playera = Playeras("Playera", "Simple White",
        1, 100, 256f)
    playera.InfoProducto()
}

open class Products(val Categoria: String, val NombreModelo: String,
                    val ID_Modelo: Int, val Unidades: Int, val Precio: Float){

    open fun InfoProducto(){
        println("Informacion Ingresada: ")
        println("Nombre: "+NombreModelo)
        println("Categoria: "+Categoria)
        println("ID: "+ID_Modelo)
        println("Stock: "+Unidades)
        println("Precio: $"+Precio)
    }
}

//Heredando Atributos y Metodos de Clase Productos
class Playeras(Categoria: String, NombreModelo: String, ID_Modelo: Int,
               Unidades: Int, Precio: Float): Products(Categoria,
    NombreModelo, ID_Modelo, Unidades, Precio){

    override fun InfoProducto(){
        println("Informacion Ingresada: ")
        println("Categoria: "+Categoria)
        println("Modelo: "+NombreModelo)
        println("ID producto: "+ID_Modelo)
        println("Stock: "+Unidades)
        println("Precio: $"+Precio)
    }
}

data class Stickers(val Categoria: String, val NombreModelo:String,
                    val ID_Modelo: Int, val Unidades: Int, val Precio: Float){}

abstract class Usuarios(val Nombre: String, val apellP: String, val apellM: String,
                        val email: String, val telefono: Long, val Direccion: String){
    abstract fun mostrarInformacion()
}

class Cliente(Nombre: String, apellP: String, apellM: String, email: String, telefono: Long,
              Direccion: String, val tipoCliente: String): Usuarios(Nombre, apellP, apellM, email, telefono, Direccion){

    override fun mostrarInformacion() {
        println("Informacion Ingresada: ")
        println(Nombre)
        println(apellP)
        println(apellM)
        println(email)
        println(telefono)
        println(Direccion)
        println(tipoCliente)
    }
}