package projectoAmigosCool

class PaymentStatus (name: String) : Products(name),StatusPayment{

    override fun statusPayment() {   ///Función para cancelar pago
        println("Desea continuar con el pago ingrese si pa continuar y no para cancelar")
        val statusPayment = readLine()!!.toString()
        if(statusPayment.equals("si")){
            reserved=true
            println("Pago efectuado")
        }else{
            cancelPayment()
        }

    }

    override fun cancelPayment() {
            reserved=false
            paidAmount=0.0
            println("Pago cancelado exitosamente!")
    }

}