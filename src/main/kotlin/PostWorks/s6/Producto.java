package PostWorks.s6;



public abstract class Producto {
    float precio;
    String modelo;
    String numPedido;

    public Producto(float precio, String modelo,
                    String numPedido) {
        this.precio = precio;
        this.modelo = modelo;
        this.numPedido = numPedido;
    }

    public abstract float getTotalPrice(int total);
}
