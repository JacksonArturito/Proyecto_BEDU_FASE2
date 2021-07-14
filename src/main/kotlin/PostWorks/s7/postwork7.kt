package PostWorks.s7



const val CARD_LENGTH = 16

fun main() {

    class Postwork7 (val name: String,
                     var age: Int,
                     val email: String) {

        fun cardRegister(numCta: Long): Boolean {
            fun validar(card: Long): Boolean{
                if (card.toString().length == CARD_LENGTH) {
                    return true
                } else if(card.toString().length > CARD_LENGTH || card.toString().length < CARD_LENGTH){
                    return false
                }else {
                    return false
                }
            }
            val cardValidate = validar(numCta)
            return cardValidate
        }
    }

    var post7 = Postwork7(" Esteban ", 18, "estebancorreo@email.com")
    println("Datos del Cliente")
    println("Nombre: "+post7.name)
    println("Edad: "+post7.age)
    println("Email: "+post7.email)
    println("** Registro de Tarjeta **")
    println("Ingrese su #Tarjeta: ")

    try {
        val numCard: Long = readLine()!!.toLong()
        val validacion = post7.cardRegister(numCard)
        println("Validando...")
        Thread.sleep(500)
        if (validacion == true) {
            println("Registro de Tarjeta Exitoso")
        } else{
            println("Número invalido de tarjeta, intente de nuevo")
            main()
        }
    } catch (e: Exception){
        println("Por favor ingrese unicamente números. Error $e")
        println("Inténtelo de nuevo")
        main()
    }

}





