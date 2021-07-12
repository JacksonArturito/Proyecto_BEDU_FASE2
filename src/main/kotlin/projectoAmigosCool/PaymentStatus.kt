package projectoAmigosCool

class PaymentStatus (name: String) : Products(name),Cancellable{

    override fun cancelPayment() {
        if (paid){
            paid=false
            paidAmount=0
            println("Pago cancelado exitosamente!")
        }else{
            println("Esta compra no ha sido realizada")
        }
    }
}