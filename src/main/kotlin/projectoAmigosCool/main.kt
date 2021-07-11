package projectoAmigosCool


fun main() {

    val loginUser = LoginUser()

    do {
        println("!Hola Bienvenido a la Tienda de Amigos Cool")

        try {
            println("Escribe una opción del menu : ")
            println("1) Iniciar sesion")
            println("2) Registrarse")
            println("3) Consultar Productos")

            var number = Integer.valueOf(readLine())

            when (number) {
                1 -> println("Iniciar Sesión")
                2 -> loginUser.registerUser()
                3 -> {
                    val products = Products("Playeras", 23)
                    println("Ingresa nombre del cataogo del Producto")
                    println(" ----------- Playeras -----------------")
                    println(" ----------- Sudaderas -----------------")
                    println(" ----------- Stickers -----------------")
                    println(" ----------- Juegos -----------------")
                    val name = readLine()!!.toString()
                    products.getInventary(name)
                }
                else -> println("Opción no valida")
            }
        } catch (e: NumberFormatException) {
            println("Por favor, escribe una opción válida")
        }
        println("Regresar al menu?: (S/N)")
        var returnMenu = readLine()!!.toString()
    }while (returnMenu == "S")

}