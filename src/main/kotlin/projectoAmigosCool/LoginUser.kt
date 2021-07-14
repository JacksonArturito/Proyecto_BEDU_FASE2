package projectoAmigosCool

class LoginUser {
    val users = arrayListOf(User("jazmin.icss@gmail.com", "123456"))

    fun registerUser(){       //Función para registrar usuario
        println("Ingresa correo electrónico")
        val email = readLine()!!.toString()
        println("Ingresa Contraseña")
        val password = readLine()!!.toString()
        val exitsEmail = users.find { it.email == email } ///Busca si se encuentra el correo electrónico en el sistema
        if (exitsEmail == null){       //Si no existe el correo electrónico proporcionado por el usuario se crea el usuario y notificamos al usuario
            users.add(User(email,password))
            println("Registro realizado con exito !")
            //println(users)
        }else{                        //Si existe el correo electrónico proporcionado por el usuario notificamos al usuario
            println("Ya esta en uso este correo electrónico. Puede intentar con otro. ")
        }
    }

    fun login(estado: Boolean): Boolean{
        var sesion = estado
        println("Ingresa correo electrónico")
        val email = readLine()!!.toString()
        println("Ingresa contraseña")
        val password = readLine()!!.toString()
        println("Validando usuario...")

        if(email=="jazmin.icss@gmail.com" && password=="123456"){ // Realiza una validación si coinciden el correo electrónico y la contrseña
            println("Inicio de sesión exitoso")
            sesion = true
        } else{
            println("email o contraseña incorrecto")
            sesion = false
        }
        return sesion
    }
}