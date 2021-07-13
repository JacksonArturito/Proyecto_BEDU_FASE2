package PostWorks.s8rf

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

fun main() = runBlocking {
    try {
        println("Iniciando recuperación de datos usuario.................")
        val user = fetchUserCoroutine("Ana Jazmin", "123456")
//        updateUser(user)
        println(user)
    } catch (exception: Exception) {
        println("Error: $exception")
    }
}

private suspend fun fetchUserCoroutine(username: String, password: String): User =
    suspendCancellableCoroutine { cancellableContinuation ->
        fetchUser(object : Callback {
            override fun onSuccess(user: User) {
                cancellableContinuation.resume(user)
            }

            override fun onFailure(exception: Exception) {
                cancellableContinuation.resumeWithException(exception)
            }
        })
    }

private fun fetchUser(callback: Callback) {
    Thread {
        Thread.sleep(3_000)

        // onSuccess
        callback.onSuccess(
            User(
                "Ana Jazmin",
                "gmjklkj9dif9rfk9rfk9d",
                28,
                "Female",
                1000
            )
        )
        // onFailure
//        callback.onFailure(Exception("Excepción genérica"))
    }.start()
}

data class User(
    val Username: String,
    val token: String,
    val age: Int,
    val gender: String,
    val credit: Long
)

interface Callback {
    fun onSuccess(user: User)
    fun onFailure(exception: Exception)
}
