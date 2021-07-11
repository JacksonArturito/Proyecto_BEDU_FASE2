package projectoAmigosCool

class LoginUser {

    val users = arrayListOf(User("jazmin.icss@gmail.com", "123456"))

    fun registerUser(){       //Función para registrar usuario
        println("Ingresa correo electrónico")
        val email = readLine()!!.toString()
        println("Ingresa Contraseña")
        val password = readLine()!!.toString()
        val exitsEmail = users.find { it.email == email }
        if (exitsEmail == null){       //Si no existe el correo electrónico proporcionado por el usuario se crea el usuario y notificamos al usuario
            users.add(User(email,password))
            println("Registro realizado con exito !")
            println(users)
        }else{                        //Si existe el correo electrónico proporcionado por el usuario notificamos al usuario
            println("Ya esta en uso este correo electrónico. Puede intentar con otro. ")
        }
    }

    fun loginUser(){

    }
}